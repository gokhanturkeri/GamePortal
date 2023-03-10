package com.GamePortal.Repository;

import com.GamePortal.Entity.UserInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserExcelExportRepository extends CrudRepository<UserInformation, Long> {

}
