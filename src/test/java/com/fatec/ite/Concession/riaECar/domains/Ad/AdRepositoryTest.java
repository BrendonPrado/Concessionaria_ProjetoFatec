package com.fatec.ite.Concession.riaECar.domains.Ad;

import com.fatec.ite.Concessionaria.ConcessionáriaECarApplication;
import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.ad.AdRepository;
import com.fatec.ite.Concessionaria.domains.ad.AdStatus;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.car.CarRepository;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes={ConcessionáriaECarApplication.class})
public class AdRepositoryTest {


    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CarRepository carRepository;

    @Autowired
    public AdRepository adRepository;

    @Before
    public void ini(){
        User user = userRepository.save(new User("babasuau","msdsidmi","snnsdd",20));
        Car car = carRepository.save(new Car(null,"Uno","Fiat","apdwk0o290920",2020,user,null,null));
        car.setUserOwner(user);
        carRepository.save(car);

        adRepository.save(new Ad(null,user,car,2000, AdStatus.Available));
    }
    
    @Test
    public void testaFindStatus(){
        List<Ad> ad = adRepository.findByAdStatus(AdStatus.Available);
        System.out.println(adRepository.findAll().size());
        Assert.assertEquals(AdStatus.Available,ad.get(0).getAdStatus());
    }

    @Test
    public void testaPegaPrecoMaior(){
        List<Ad> ads = adRepository.pegarMaiorPrecoQue(1500);
        ads.removeIf(a -> a.getPrice() <= 1500);
        Assert.assertTrue(ads.size() > 0);
        Assert.assertTrue(ads.get(0).getPrice() > 1500);
    }

}
