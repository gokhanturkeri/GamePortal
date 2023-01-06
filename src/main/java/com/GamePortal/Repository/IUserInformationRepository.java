package com.GamePortal.Repository;

import com.GamePortal.Entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserInformationRepository extends JpaRepository<UserInformation, Long> {

    List<UserInformation> findByUserCreditLessThan(int userCredit);
}
