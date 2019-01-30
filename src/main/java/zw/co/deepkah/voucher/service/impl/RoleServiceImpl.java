package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.security.Role;
import zw.co.deepkah.voucher.repository.RoleRepository;
import zw.co.deepkah.voucher.service.RoleService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Optional<List<Role>> findAll() {
        return Optional.ofNullable(roleRepository.findAll());
    }

    @Override
    public Optional<Role> getOne(String Id) {
        return Optional.ofNullable(roleRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
      roleRepository.deleteById(Id);
    }

    @Override
    public void remove(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
