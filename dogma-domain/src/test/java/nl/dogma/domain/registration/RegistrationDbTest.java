package nl.dogma.domain.registration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RegistrationDbTest {

    @Before
    public void init() {
        RegistrationDb.getInstance().clear();
    }

    @Test
    public void indienTweeInLijstDanBijGetRegsTwee() {
        // given
        String userid = "user";
        Registration reg1 = new Registration();
        reg1.setId("id");
        reg1.setUserid(userid);
        Registration reg2 = new Registration();
        reg2.setId("id2");
        reg2.setUserid(userid);

        RegistrationDb.getInstance().addRegistration(reg1);
        RegistrationDb.getInstance().addRegistration(reg2);

        // when
        List<Registration> regs = RegistrationDb.getInstance().getRegistrations(userid);

        // then
        Assert.assertEquals(2, regs.size());
    }


    @Test
    public void indienInLijstDanBijRemoveVerwijderd() {
        // given
        String userid = "user";
        Registration reg1 = new Registration();
        reg1.setId("id");
        reg1.setUserid(userid);
        Registration reg2 = new Registration();
        reg2.setId("id2");
        reg2.setUserid(userid);

        RegistrationDb.getInstance().addRegistration(reg1);
        RegistrationDb.getInstance().addRegistration(reg2);

        // when
        RegistrationDb.getInstance().removeRegistration(userid, reg1.getId());

        // then
        Assert.assertEquals(1, RegistrationDb.getInstance().getRegistrations(userid).size());
    }

    @Test
    public void indienInLijstDanBijRemoveAndereUserNIETVerwijderd() {
        // given
        String userid = "user";
        Registration reg1 = new Registration();
        reg1.setId("id");
        reg1.setUserid(userid);
        Registration reg2 = new Registration();
        reg2.setId("id2");
        reg2.setUserid(userid);

        RegistrationDb.getInstance().addRegistration(reg1);
        RegistrationDb.getInstance().addRegistration(reg2);

        // when
        RegistrationDb.getInstance().removeRegistration("userid2", reg1.getId());

        // then
        Assert.assertEquals(2, RegistrationDb.getInstance().getRegistrations(userid).size());
    }

}
