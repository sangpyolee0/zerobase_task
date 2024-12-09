<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <title>와이파이 정보 구하기</title>
</head>
<body>
    <div class="container">
        <h1>와이파이 정보 구하기</h1>
        <nav>
            <a href="index.jsp">홈</a>
            <span>|</span>
            <a href="history.jsp">위치 히스토리 목록</a>
            <span>|</span>
            <a href="add-wifi.jsp">Open API 와이파이 정보 가져오기</a>
        </nav>
        <form id="wifiForm">
            <label for="lat">LAT:</label>
            <input type="text" id="lat" name="lat" placeholder="위도 입력">
            <label for="lnt">LNT:</label>
            <input type="text" id="lnt" name="lnt" placeholder="경도 입력">
            <button type="button" onclick="setCustomLocation()">내 위치 설정</button>
            <button type="button" onclick="fetchWifiData()">근처 WIFI 정보 보기</button>
        </form>
        <table>
            <thead>
                <tr>
                    <th>거리(Km)</th>
                    <th>관리번호</th>
                    <th>자치구</th>
                    <th>와이파이명</th>
                    <th>도로명주소</th>
                    <th>상세주소</th>
                    <th>설치위치(층)</th>
                    <th>설치유형</th>
                    <th>설치기관</th>
                    <th>서비스구분</th>
                    <th>망종류</th>
                    <th>설치년도</th>
                    <th>실내외구분</th>
                    <th>WIFI접속환경</th>
                    <th>X좌표</th>
                    <th>Y좌표</th>
                    <th>작업일자</th>
                </tr>
            </thead>
            <tbody id="wifiTable">
                <!-- 데이터가 렌더링됩니다. -->
            </tbody>
        </table>
        <p class="message">위치 정보를 입력한 후에 조회해 주세요.</p>
    </div>
</body>
<script>
    // 사용자 입력 위치로 설정
    function setCustomLocation() {
        const lat = document.getElementById('lat').value;
        const lnt = document.getElementById('lnt').value;

        if (!lat || !lnt) {
            alert('위도와 경도를 모두 입력해야 합니다.');
        } else {
            alert(`위치가 설정되었습니다: LAT=${lat}, LNT=${lnt}`);
        }
    }

    // 근처 WiFi 데이터 가져오기
    function fetchWifiData() {
        const lat = document.getElementById('lat').value;
        const lnt = document.getElementById('lnt').value;

        if (!lat || !lnt) {
            alert('위도와 경도를 입력하세요.');
            return;
        }

        fetch(`nearby-wifi.jsp?lat=${lat}&lnt=${lnt}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('네트워크 응답이 실패했습니다.');
                }
                return response.json();
            })
            .then(data => {
                const tableBody = document.getElementById('wifiTable');
                tableBody.innerHTML = ''; // 테이블 초기화
                if (data.length === 0) {
                    alert('근처 WiFi 정보를 찾을 수 없습니다.');
                    return;
                }

                data.forEach(wifi => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${wifi.distance}</td>
                        <td>${wifi.id || 'N/A'}</td>
                        <td>${wifi.district || 'N/A'}</td>
                        <td>${wifi.name || 'N/A'}</td>
                        <td>${wifi.roadAddress || 'N/A'}</td>
                        <td>${wifi.detailAddress || 'N/A'}</td>
                        <td>${wifi.floor || 'N/A'}</td>
                        <td>${wifi.installType || 'N/A'}</td>
                        <td>${wifi.installAgency || 'N/A'}</td>
                        <td>${wifi.serviceType || 'N/A'}</td>
                        <td>${wifi.networkType || 'N/A'}</td>
                        <td>${wifi.installYear || 'N/A'}</td>
                        <td>${wifi.indoorOutdoor || 'N/A'}</td>
                        <td>${wifi.environment || 'N/A'}</td>
                        <td>${wifi.xCoord || 'N/A'}</td>
                        <td>${wifi.yCoord || 'N/A'}</td>
                        <td>${wifi.date || 'N/A'}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => {
                console.error('Error fetching WiFi data:', error);
                alert('WiFi 데이터를 가져오는 중 오류가 발생했습니다.');
            });
    }
</script>
</html>
