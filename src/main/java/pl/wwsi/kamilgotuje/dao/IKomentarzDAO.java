package pl.wwsi.kamilgotuje.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wwsi.kamilgotuje.model.Komentarz;

import java.util.UUID;

@Qualifier("komentarzdao")
@Repository
public interface IKomentarzDAO extends CrudRepository<Komentarz, UUID> { }
