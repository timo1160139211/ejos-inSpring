//import com.alibaba.fastjson.JSON;
//
//import site.gaoyisheng.pojo.User;
//import site.gaoyisheng.service.UserService;  
//  
//@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
//public class TestMe {
//private static Logger logger = Logger.getLogger(TestMe.class);  
//
//    @Autowired 
//    private UserService userService;  
//  
////  @Before  
////  public void before() {  
////      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
////      userService = (IUserService) ac.getBean("userService");  
////  }  
//  
//    @Test
//    public void test1() {  
//        User user = userService.getUserById("adadwqw");  
//        // System.out.println(user.getUserName());  
//        // logger.info("值："+user.getUserName());  
//        logger.info(JSON.toJSONString(user));  
//    }  
//} 