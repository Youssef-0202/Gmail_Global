package ma.zs.emailling.unit.dao.facade.core.email;

import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import ma.zs.emailling.dao.facade.core.email.EmailpieceJointDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.bean.core.commun.TypeContenu ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmailpieceJointDaoTest {

@Autowired
    private EmailpieceJointDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EmailpieceJoint entity = new EmailpieceJoint();
        entity.setId(id);
        underTest.save(entity);
        EmailpieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EmailpieceJoint entity = new EmailpieceJoint();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EmailpieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EmailpieceJoint> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EmailpieceJoint> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EmailpieceJoint given = constructSample(1);
        EmailpieceJoint saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EmailpieceJoint constructSample(int i) {
		EmailpieceJoint given = new EmailpieceJoint();
        given.setEmail(new Email(1L));
        given.setPath("path-"+i);
        given.setTaille("taille-"+i);
        given.setTypeContenu(new TypeContenu(1L));
        return given;
    }

}
