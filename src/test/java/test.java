

import com.wavenet.maintenance.dao.mapper.TZaiqingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;


public class test {


    @Autowired
    private TZaiqingInfoMapper tZaiqingInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public   void main(String[] args) {

        String[][] strings = new String[100][100];

        strings[0][0]="a";
        strings[0][1]="a";
        strings[1][0]="a";
        strings[1][1]="a";
        strings[2][0]="a";
        strings[2][1]="a";
        strings[3][0]="a";
        strings[3][1]="a";
        System.out.println(strings);

        redisTemplate.opsForValue().set("123",123);
        redisTemplate.opsForValue().get("123");
        redisTemplate.opsForValue().set("1234",1234,10, TimeUnit.HOURS);



    }




    }



