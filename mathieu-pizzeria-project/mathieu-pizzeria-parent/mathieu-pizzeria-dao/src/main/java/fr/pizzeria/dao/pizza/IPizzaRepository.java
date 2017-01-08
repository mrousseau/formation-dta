package fr.pizzeria.dao.pizza;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

/**
 * @author mathieu
 *
 */
public interface IPizzaRepository  extends JpaRepository<Pizza, Long>  {
}
