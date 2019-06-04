package com.example.yubaby;

import com.example.yubaby.dao.RedisUtil;
import com.example.yubaby.dao.community.ShuoshuoDao;
import com.example.yubaby.dao.me.UserDao;
import com.example.yubaby.pojo.home.BabyChange;
import com.example.yubaby.pojo.home.DirArticle;
import com.example.yubaby.pojo.me.User;
import com.example.yubaby.pojo.shop.ShopItem;
import com.example.yubaby.service.shop.ShopService;
import com.example.yubaby.util.UserUtil;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.yubabay.dao")
public class YubabyApplicationTests {
    @Autowired
    ShopService shopService;
    @Autowired
    ShuoshuoDao shuoshuoDao;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserDao userDao;
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test() {
        DirArticle dirArticle = mongoTemplate.findOne(new Query(),DirArticle.class);
        System.out.println(dirArticle);
//        for(DirArticle dirArticle: list) {
//            DirArticle dirArticle2 = new DirArticle();
//            dirArticle2.setkId(dirArticle.getuId());
//            dirArticle2.setsId(dirArticle.getsId());
//            List<Integer> list2 = new ArrayList<>();
//            List<String> list3 = dirArticle.getItem();
//            try {
//                for (int i = 0; i < 50; i++) {
//                    list2.add(Integer.valueOf(list3.get(i)));
//                }
//            } catch (Exception e) {
//                System.out.println("next");
//            }
//            dirArticle2.setItem(list2);
//            mongoTemplate.insert(dirArticle2);
//        }
    }

    @Test
    public void doTest() {
        List<BabyChange> list = mongoTemplate.findAll(BabyChange.class);
        for(BabyChange babyChange: list) {
            List<Map<String, Object>> sub = babyChange.getSub();
            for (int i = 0; i < sub.size(); i++) {
                List<String> content_list = (List<String>) sub.get(i).get("content");
                int content_list_size = content_list.size();
                if(content_list_size == 0) {
                    System.out.println(babyChange.getWeek());
                    continue;
                }
                for (int j = 0; j < content_list.size(); j++) {
                    if(content_list.get(j).equals("") || content_list.get(j).startsWith("<")) {
                        System.out.println("删除");
                        content_list.remove(j);
                    }
                }
            }
        }
//        for(BabyChange babyChange: list){
//            babyChange.setId(null);
//            mongoTemplate.insert(babyChange);
//            System.out.println(babyChange);
//        }
    }

//    2
//9
//11
//14
//20
//20
//23
//29
//34
//39
    @Test
    public void doTest2() {
        Query query = new Query();
        query.addCriteria(Criteria.where("week").is(2));
        BabyChange babyChange = mongoTemplate.findOne(query, BabyChange.class);
        System.out.println(babyChange);
    }

    @Test
    public void doTest3() {
//        User user = userDao.selectByPrimaryKey(5);
//        String md5Password = DigestUtils.md5DigestAsHex((user.getPassword()+Const.SALT).getBytes()); //加密两次 userr
//        md5Password = DigestUtils.md5DigestAsHex((md5Password+Const.SALT).getBytes());
//        String avatar = DigestUtils.md5DigestAsHex(user.getMail().getBytes());
//        user.setPassword(md5Password);
//        user.setAvatar(avatar);
//        userDao.updateByPrimaryKey(user);
        for(int i=1; i<6; i++) {
            User user = userDao.selectByPrimaryKey(i);
            user.setAvatar(UserUtil.getAvatar(user.getMail()));
            user.setPassword(UserUtil.getMd5Password(user.getAccount(), user.getPassword()));
            userDao.updateByPrimaryKey(user);
        }
    }

    @Test
    public void doTest5() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("2903785847@qq.com");
        mailMessage.setTo("2892953017@qq.com");
        mailMessage.setSubject("育宝宝邮件");
        mailMessage.setText("你的验证码：1111，有效期5分钟");
        mailSender.send(mailMessage);
    }

    @Test
    public void deTest6() {
        System.out.println(redisUtil.setCode("xiaoman"));
        System.out.println(redisUtil.getCode("xiaoman"));
        System.out.println(redisUtil.removeCode("xiaoman"));
    }

    @Test
    public void doTest7() {
        LocalDate date = new LocalDate("2018-11-11");
        LocalDate date2 = new LocalDate();
        LocalDate date3 = new LocalDate("2019-10-1");
//       前小后大正数 d3 > d2 > d1
        System.out.println(Days.daysBetween(date, date2).getDays());
        System.out.println(Days.daysBetween(date2, date).getDays());
        System.out.println(Days.daysBetween(date2, date3).getDays());
        System.out.println(Days.daysBetween(date3, date2).getDays());

    }

    @Test
    public void doTest8() {
        int a = 100;
        System.out.println(a/7+1); // 17*
    }

    @Test
    public void contextLoads() {
        for(int k = 1; k < 8; k++) {
            for (int j = 0; j < 20; j++) {
                ShopItem shopItem = new ShopItem();
                shopItem.setCategoryId(k);
                Random random = new Random();
                int i = random.nextInt(10) + 13;
                int i2 = random.nextInt(5) + 1;
                int i3 = random.nextInt(10);
                System.out.println(i);
                System.out.println(i2);
                shopItem.setuId(i2);
                shopItem.setTitle("这是测试商品标题" + i*i2);
                shopItem.setContent("这是测试商品内容" + i+i2);
                shopItem.setSource(i);
                shopItem.setLink("这是一个测试连接");
                switch (i3) {
                    case 0:
                        shopItem.setPrice(11.99);
                        break;
                    case 1:
                        shopItem.setPrice(25.00);
                        break;
                    case 2:
                        shopItem.setPrice(34.99);
                        break;
                    case 3:
                        shopItem.setPrice(49.90);
                        break;
                    case 4:
                        shopItem.setPrice(51.00);
                        break;
                    case 5:
                        shopItem.setPrice(66.66);
                        break;
                    case 6:
                        shopItem.setPrice(77.77);
                        break;
                    case 7:
                        shopItem.setPrice(88.88);
                        break;
                    case 8:
                        shopItem.setPrice(99.99);
                        break;
                    case 9:
                        shopItem.setPrice(111.11);
                        break;
                }
                shopService.addShopItem(shopItem);
            }
        }
    }
}
