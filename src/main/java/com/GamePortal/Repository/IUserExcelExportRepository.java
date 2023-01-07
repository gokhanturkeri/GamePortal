package com.GamePortal.Repository;

import com.GamePortal.Entity.UserInformation;
import org.springframework.data.repository.CrudRepository;

public interface IUserExcelExportRepository extends CrudRepository<UserInformation, Long> {

}
