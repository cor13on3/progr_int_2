package pl.wwsi.kamilgotuje.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wwsi.kamilgotuje.model.Przepis;

import java.util.UUID;

@Qualifier("przepisdao")
@Repository
public interface IPrzepisDAO extends CrudRepository<Przepis, UUID> { }
