Spring.md

프레임워크(FrameWork): 어떤 대상을 구성하는 구조/틀/뼈대 
	-> 소프트웨어적 개념: 기능을 미리 클래스/인터페이스 형태로 
						 만들어 제공하는 반제품 
						 즉, 어느정도 만들어진 프로젝트 (밀키트)
						 
						 						  
스프링 프레임워크(Spring Framework) 
-> 자바-웹 애플리케이션을 개발하기위한 오픈소스 프레임워크 

- 경량 프레임워크(Spring Framework)
	-> 자바-웹 애플리케이션을 개발하기위한 오픈소스 프레임워크
	-> 경량 프레임워크 / 경량 컨테이너(톰켓 - 서블릿 컨테이너) 

- EJB(서버중심개발) / 중량 프레임워크 / 확장성, 유지보수 
                          ||
- Spring(클라이언트중심 개발) / 경량프레임워크 / 생산성, 안정성 (모바일) 

* 스프링의 주요 개념 
 - POJO(Plain Old Java Object)기반(방식)의 프레임워크	
 - 제어의 역행(IoC, Inversion of Control)기술을 사용해서 
   어플리케이션간의 느슨한 결합을 제어 
   -> 서블릿, 빈(객체)등을 개발자가 코드로 직접생성x 
    	- 프레임워크가 직접 수행
    	 
 - 의존성 주입(DI, Dependency Injection)기능을 지원 
 	-> 클래스 객체를 개발자가 코드로 직접 생성x 
 		- 프레임워크가 생성해놓은 객체를 가져다가(주입받아서) 사용o
 		
 - 관점지향 프로그래밍(AOP, Aspect-Oriented Programming)을 사용하여	            자원관리 
	-> 핵심기능과 부수기능을 분리구현 (모듈성 증가)
	 
 - 영속성(Persistence)관련 다양한 서비스를 지원 

* 스프링 주요기능 
	- Core: 다른기능들과 설정값을 분리하기 위한 IoC기능을 제공
	- Context: 스프링의 기본기능, 애플리케이션의 각 기능을 수행하는 
		  	   Bean(객체)에 대한 접근 방법을 제공 
	- DAO: JDBC기능을 편리하게 사용가능한 기능을 제공 
	- ORM: 영속성 프레임워크연동 기능을 제공(하이버네이트 - 쿼리생성, 		    			마이바티스)
	- AOP: 관점지향 프로그래밍 제공 
	- Web: 웹 어플리케이션 개발에 필요한 기능제공 
	- webMVC: 스프링 MVC 기능을 제공 

* Spring Legacy Project(Spring Framework)
	- 아직까지 실무에서 사용되고있는 프로젝트
	- 기존프로젝트 이해에 도움 
	- 다양한 소스코드/구글링이 가능 
	- 모든 버전의 스프링을 사용가능 
	<단점>
	- 초반 설정이 어려움 
	- WAS(Tomcat)서버 리소스가 많이 필요함 

* Spring Starter Project(Spring Boot)
	- 별도의 설정 없이 사용가능 
	- WAS없이 실행가능(내장서버) -> 처리/로딩속도가 빠름 
	- 기존의 시스템과 다른 형태의 구성 
	- JSP의 활용이 까다로움 
	- 스프링 버전에 알맞은 설정값이 세팅되어있음 
	
 MVC
					
 request -> Web.xml -> Controller -> Model -> DB
 							|
 							|		    
 						  	|
 						  View
 						  	|		2)handlerMapping
 SpringMVC					|			 //
 							|			//
 request -> Web.xml -> 1)DispactcherServlet = 3)HandlerAdater  					
										 \\
										  \\				
										5)viewResolver	
										
-> 4)Controller -> Service -> DAO -> DB
* 웹 프로젝트의 구성 
	- presentation Layer: UI를 구성하는 요소를 표현가능 - controller, view
						  모바일/웹 
	- Business Layer: Service계층, 사용자의 요구사항을 - Service
					  구현하는 계층 
	- Data Access Layer(Persistence Layer): 데이터 처리 계층 - DAO,DB
	- DataBase
	
	
* |DataAccess Layer|
  [Spring] -> DAO -> MyBatis -> DB
  
* MyBatis : SQL Mapping 라이브러리, JDBC연결에 필요한 다양한 기능/편의성 			제공(try-catch-finally 제거, 디비 연결, pstmt.setXXX(), 			rs.getXXX())
			SQL구문을 코드와 분리해서 사용 
			Spring과 MyBatis의 자동 연동(필요 라이브러리)
			동적 SQL기능 제공 
			
(iBatis -> MyBatis)
방법 1) XML파일에 SQL구문설정, DAO에서 연결해서 실행
	장점: SQL구문을 별도 처리, SQL수정 및 프로젝트 유지보수에 유리 
	단점: 작성해야하는 코드량이 증가(복잡함)

방법 2) 어노테이션 + 인터페이스 사용해서 SQL 실행 
	장점: DAO 객체 없이 인터페이스만으로 개발 -> 생산성 증가
	단점: SQL수정이 발생하는 경우 매번 컴파일 
	
방법 3) XML + 인터페이스 설정해서 실행 - 방법 1 + 2
	장점: 간단한 SQL는 어노테이션(방법2), 복잡한 SQL구문은 XML(방법1)
	단점: 개발자의 능력에 따른 방식이 구분 
	
* MyBatis 사용방법 
- 디비 생성 & 테이블 생성 (DB관련 준비)
- 도메인 객체 설계 & 클래스 생성 
  
  도메인: 개발에 필요한 중요한 개념을 나타내는 것 
  		  (물리적으로 구분가능한 단위)
  		  
- DAO 인터페이스 생성 
- 실행할 기능을 인터페이스 추상메서드로 정의
- XML Mapper 생성 
- mapper DTD 추가설정(xml을 어떠한 형태로 읽어줄지 알려주는 설명) 
- mapper의 저장위치 설정(Namespace) 
- SQL구문 작성 
- Mybatis에서 작성한 Mapper를 연결 
- DAO 인터페이스 구현(서브 클래스 생성)
- DAO 동작호출 & 테스트 

** DB(SQL) 실행하는 순서 
Test -> DAT -> DATOImpl -> sqlSession -> MyBatis -> Mapper -> DB

* 회원가입
* 로그인 
* 회원정보 조회 
* 회원수정 

* 회원탈퇴 
	- sql (delete 구문 -'ID/PW 확인 후 삭제')작성
	- DAO 동작(리턴값) -> DAOImpl 구현
	- Test 호출
	
* 회원정보 목록(list)
	- sql (select 구문 -'ID/PW 확인 후 삭제')작성
	- DAO 동작(리턴값) -> DAOImpl 구현
	- Test 호출
	
* SpringMVC가 처리하는 작업 (자동)
	- URI를 분석해서 적절한 컨트롤러를 찾기(*.me, *.bo ...)
	- 컨트롤러에 필요한 메서드호출 
	- 컨트롤러의 결과를 뷰페이지로 전달 
	- 적절한 뷰페이지 연결 
	- 파라미터 자동수집 
	
* 개발자가 처리하는 작업 (해야할 작업)
	- 특정 URI에 해당하는 컨트롤러를 생성 
	- 서비스 객체 (중간계층)
	- DAO 객체 
	- 컨트롤러에 수행하고자하는 동작을 메서드로 정의
	- 뷰페이지에 전달받은 데이터 출력 
	
	
	
404 는 매핑 페이지 전부 없음 
405 는 get인 post중에 하나만 존재 
	


* 의존 객체 자동주입(Automatic Dependency Injection)
 : 스프링설정파일(root-context.xml/servlet-context.xml)에서
  생성된 객체(빈)을 스프링 컨테이너가 자동으로 
  의존대상 객체를 찾아서 주입하는 것 
  
  @Inject
  	- Java에서 지원하는 어노테이션(특정 프레임워크에 비종속석)
  	- 객체를 찾는 순서 
  	  [ 타입 -> @Qualifier -> 이름 -> 실패]
  	- 사용가능 위치 
  	  멤버변수, set(), 생성자, 일반 메서드 
  	
  	
  @Autowired
    - Spring에서 지원하는 어노테이션(특정 프레임워크에 종속적)
    - 객체를 찾는 순서 
     [타입 -> 이름 -> @Qualifier -> 실패]
    - 사용가능 위치
      멤버변수, set(), 생성자, 일반 메서드 
      
  @Resource  
   	- Java에서 지원하는 어노테이션(특정 프레임워크에 비종속석)
    - 객체를 찾는 순서 
      [이름 -> 타입 -> @Qualifier -> 실패]
    - 사용가능 위치 
      멤버변수, set()
      
  @Qualifier: 동일한 두개 이상의 객체를 구분하기 위한 값 
  
  	<bean id="dataSource" 
		  class="com.zaxxer.hikari.HikariDataSource"
		  <qualifier value="ds1/dsOracle"/> 
	</bean>	
	
<bean id="dataSource" 
		  class="com.zaxxer.hikari.HikariDataSource"
		<qualifier value="ds2/dsMysql"/>
	</bean>
  	
  	@Inject
  	@Qualifier("ds1")
  	private DataSource ds;
	

계층형 패키지 
장점: 구조파악이 쉬움 
단점: 패키지에 많은 파일들이 모여있음 

com.itwillbs.controller
	MemberController
	BoardController
	GoodsController 
	....
	
com.itwillbs.domain

com.itwillbs.persistence

com.itwillbs.service
	
도메인형 패키지 
장점: 관련된 코드끼리 묶여있음, 모듈화 하기 쉬움 
단점: 프로젝트 구조에 대한 이해가 부족하면 어려움 
	  패키지간의 순환참조 발생가능성 높음 


com.itwillbs.member.controller 
com.itwillbs.member.domain
com.itwillbs.member.persistence
com.itwillbs.member.service

com.itwillbs.board.controller 
com.itwillbs.board.domain
com.itwillbs.board.persistence
com.itwillbs.board.service

* 요구사항 정의 
[게시판 만들기]

- 게시판 글쓰기 
	'제목', '작성자', '내용'을 입력받아서 디비 테이블에 저장 
	
- 게시판 리스트 
	디비에서 정보를 조회해서 저장된 값을 가져와서 화명에 출력 
	
- 게시판 본문보기 
	디비에서 특정 글의 정보만 가져와서 화면에 출력 
	
- 게시판 수정하기 
	기존의 글 정보를 가져와서 보여주고, 수정할 정보값을 입력받아서 	수정 
- 게시판 삭제하기 
	게시판 특정 글의 정보를 삭제 

