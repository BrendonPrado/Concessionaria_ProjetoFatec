package com.fatec.ite.Concession.riaECar.domains.Ad;


import com.fatec.ite.Concessionaria.ConcessionáriaECarApplication;
import com.fatec.ite.Concessionaria.domains.ad.*;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.car.CarRepository;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes={ConcessionáriaECarApplication.class})
public class AdServiceTest {

    @Autowired
    private AdService adService;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CarRepository carRepository;

    @Autowired
    public AdRepository adRepository;

    public static boolean dbInit = false;

    @Before
    public  void ini(){
        if(!dbInit) {
            User user = userRepository.save(new User("babasuau", "novo@novo.com", "snnsdd", 20));
            Car car = carRepository.save(new Car(null, "Fiat", "Uno", "apdwk0o290920", 2020, user, null, null));
            car.setUserOwner(user);
            carRepository.save(car);
            dbInit = true;
        }
    }

    @Test
    public void TestSaveNewAdForm() throws ObjectNotFoundException {
        Ad ad = adService.saveFromForm(new AdForm(1,1,7000));
        Ad persistedAd = adService.findById(ad.getId());
        Assert.assertEquals("Uno",persistedAd.getCar().getModel());
        Assert.assertEquals(7000,persistedAd.getPrice(),0);
        Assert.assertEquals(AdStatus.Available,persistedAd.getAdStatus());
        Assert.assertEquals("novo@novo.com",persistedAd.getSalesMan().getEmail());
    }

    @Test
    public void TestSetSold() throws ObjectNotFoundException {
        Ad ad = adService.saveFromForm(new AdForm(1,1,7000));
        adService.setSold(ad);
        Ad modifiedAd = adRepository.findById(ad.getId()).get();
        Assert.assertEquals(AdStatus.Sold,modifiedAd.getAdStatus());
    }
}
