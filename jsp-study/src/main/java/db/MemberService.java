package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

	
    public List<Member> list() {
    	
    	List<Member> memberList = new ArrayList<>();

        //접속 필요 5개
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://172.26.180.80:3306/testdb3";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";


        //접속 순서
        //1. 드라이버로드 //예외처리 방법, 감당 가능하면 처리 try catch 안되면 throws

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 커넥션 객체 생성


        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        String memberTypeValue = "email";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

//3. 스테이트먼트 객체 생성  파라미터 이슈 때문에 보통 PreparedStatement  사용

            preparedStatement = null;
            //   CallableStatement callableStatement = null;
//               statement = connection.createStatement();

              /* String sql = " select member_type, user_id, password, name " +
                            " from MEMBER " +
                            " where member_type = '" + memberTypeValue +"' ";*/
            // PreparedStatement 로 할 경우 위 커넥션 위치가 아니고 이 다음에 설정. 그리고 memberTypeValu 자리에 ? 넣기
            String sql = " select member_type, user_id, password, name " +
                    " from MEMBER " +
                    " where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);

            //4. 쿼리 실행
//               rs = statement.executeQuery(sql);
            // PreparedStatement 로 할 경우
            rs = preparedStatement.executeQuery();
            //5. 결과 수행
            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                
                Member member = new Member();
                member.setMemberType(memberTypeValue);
                member.setUserId(userId);
                member.setName(name);
                member.setPassword(password);
                
                memberList.add(member);
                

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5. 객체 연결 해체(close)
        finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        return memberList;

    }

public Member detail(String memberType, String userId) {
    	
    	Member member = null;

        //접속 필요 5개
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://172.26.180.80:3306/testdb3";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";


        //접속 순서
        //1. 드라이버로드 //예외처리 방법, 감당 가능하면 처리 try catch 안되면 throws

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 커넥션 객체 생성


        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

      
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

//3. 스테이트먼트 객체 생성  파라미터 이슈 때문에 보통 PreparedStatement  사용

            preparedStatement = null;
            //   CallableStatement callableStatement = null;
//               statement = connection.createStatement();

              /* String sql = " select member_type, user_id, password, name " +
                            " from MEMBER " +
                            " where member_type = '" + memberTypeValue +"' ";*/
            // PreparedStatement 로 할 경우 위 커넥션 위치가 아니고 이 다음에 설정. 그리고 memberTypeValu 자리에 ? 넣기
            String sql = " select m.member_type, m.user_id, m.password, m.name "
            		+ " ,md.marketing_yn "
            		+ " ,md.register_date "
            		+ " ,md.mobile_no "
            		+ " from MEMBER m "
            		+ " left join member_detail md on md.member_type = m.member_type and m.user_id = md.user_id "
            		+ " where m.member_type =? and m.user_id =? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberType);
            preparedStatement.setString(2, userId);

            //4. 쿼리 실행
//               rs = statement.executeQuery(sql);
            // PreparedStatement 로 할 경우
            rs = preparedStatement.executeQuery();
            //5. 결과 수행
            if (rs.next()) {
            	member = new Member();
                
                member.setMemberType(rs.getString("member_type"));
                member.setUserId(rs.getString("user_id"));
                member.setName(rs.getString("password"));
                member.setPassword(rs.getString("name"));
                member.setMobileNo(rs.getString("mobile_no"));
                member.setMarketingYN(rs.getBoolean("marketing_yn"));
                member.setRegisterDate(rs.getDate("register_date"));
                
                        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5. 객체 연결 해체(close)
        finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        return member;

    }

    
    public void register(Member member) {

        //접속 필요 5개
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://172.26.180.80:3306/testdb3";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";


        //접속 순서
        //1. 드라이버로드 //예외처리 방법, 감당 가능하면 처리 try catch 안되면 throws

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 커넥션 객체 생성


        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

//3. 스테이트먼트 객체 생성  파라미터 이슈 때문에 보통 PreparedStatement  사용

            preparedStatement = null;
            //   CallableStatement callableStatement = null;
//               statement = connection.createStatement();

              /* String sql = " select member_type, user_id, password, name " +
                            " from MEMBER " +
                            " where member_type = '" + memberTypeValue +"' ";*/
            // PreparedStatement 로 할 경우 위 커넥션 위치가 아니고 이 다음에 설정. 그리고 memberTypeValu 자리에 ? 넣기
            String sql = " insert into MEMBER (member_type, user_id, name, password) " +
                        " values (?, ? ,? ,?) ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getName());
            preparedStatement.setString(4, member.getPassword());


            //4. 쿼리 실행
//               rs = statement.executeQuery(sql);
            // PreparedStatement 로 할 경우
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5. 객체 연결 해체(close)
        finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        	
       


    }

    public void dbUpdate(String memberType, String userId,String password) {

        //접속 필요 5개
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://172.26.180.80:3306/testdb3";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";


        //접속 순서
        //1. 드라이버로드 //예외처리 방법, 감당 가능하면 처리 try catch 안되면 throws

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 커넥션 객체 생성


        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

//3. 스테이트먼트 객체 생성  파라미터 이슈 때문에 보통 PreparedStatement  사용

            preparedStatement = null;
            //   CallableStatement callableStatement = null;
//               statement = connection.createStatement();

              /* String sql = " select member_type, user_id, password, name " +
                            " from MEMBER " +
                            " where member_type = '" + memberTypeValue +"' ";*/
            // PreparedStatement 로 할 경우 위 커넥션 위치가 아니고 이 다음에 설정. 그리고 memberTypeValu 자리에 ? 넣기
            String sql = " update MEMBER set " +
                                " password = ? " +
                            " where member_type = ? and user_id = ? " ;

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, memberType);
            preparedStatement.setString(3, userId);
            preparedStatement.setString(1, password);


            //4. 쿼리 실행
//               rs = statement.executeQuery(sql);
            // PreparedStatement 로 할 경우
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5. 객체 연결 해체(close)
        finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }



    }

    public void withdraw(Member member) {

        //접속 필요 5개
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://172.26.180.80:3306/testdb3";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";


        //접속 순서
        //1. 드라이버로드 //예외처리 방법, 감당 가능하면 처리 try catch 안되면 throws

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 커넥션 객체 생성


        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;




        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

//3. 스테이트먼트 객체 생성  파라미터 이슈 때문에 보통 PreparedStatement  사용

            preparedStatement = null;
            //   CallableStatement callableStatement = null;
//               statement = connection.createStatement();

              /* String sql = " select member_type, user_id, password, name " +
                            " from MEMBER " +
                            " where member_type = '" + memberTypeValue +"' ";*/
            // PreparedStatement 로 할 경우 위 커넥션 위치가 아니고 이 다음에 설정. 그리고 memberTypeValu 자리에 ? 넣기
            String sql = " delete from MEMBER " +
                            " where member_type = ? and user_id = ? " ;

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());



            //4. 쿼리 실행
//               rs = statement.executeQuery(sql);
            // PreparedStatement 로 할 경우
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5. 객체 연결 해체(close)
        finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
