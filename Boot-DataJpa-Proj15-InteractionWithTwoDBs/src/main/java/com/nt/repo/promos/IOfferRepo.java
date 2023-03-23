//IOffersRepo.java
package com.nt.repo.promos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.promos.Offers;

public interface IOfferRepo extends JpaRepository<Offers, Integer> {

}//integer
