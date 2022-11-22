package net.javaSpring.springBoot.repository;

import net.javaSpring.springBoot.model.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
