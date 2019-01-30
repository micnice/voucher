package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.security.Permission;
import zw.co.deepkah.voucher.repository.PermissionRepository;
import zw.co.deepkah.voucher.service.PermissionService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionRepository permissionRepository;
    @Override
    public Optional<List<Permission>> findAll() {
        return Optional.ofNullable(permissionRepository.findAll());
    }

    @Override
    public Optional<Permission> getOne(String Id) {
        return Optional.ofNullable(permissionRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
              permissionRepository.deleteById(Id);
    }

    @Override
    public void remove(Permission permission) {
            permissionRepository.delete(permission);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }
}
