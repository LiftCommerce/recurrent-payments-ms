package com.mozido.recurrentpayments.repository.interfaces;

import com.mozido.recurrentpayments.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingJpaRepository extends JpaRepository<Setting, Long> {

    Optional<Setting> findOneByTenantName(String tenantName);

    Optional<Setting> findOneByTenantNameAndInterfaceName(String tenantName, String interfaceName);

    Optional<Setting> findOneByTenantNameIgnoreCaseAndInterfaceNameIgnoreCase(String tenantName, String interfaceName);

}
