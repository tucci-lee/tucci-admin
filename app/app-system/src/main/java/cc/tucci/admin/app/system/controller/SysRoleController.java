package cc.tucci.admin.app.system.controller;

import cc.tucci.admin.app.core.aspect.Operate;
import cc.tucci.admin.app.system.dto.body.SysRoleCreateBody;
import cc.tucci.admin.app.system.dto.body.SysRoleUpdateBody;
import cc.tucci.admin.app.system.dto.body.SysRoleUpdateResBody;
import cc.tucci.admin.app.system.service.SysRoleAppService;
import cc.tucci.admin.domain.core.dto.Response;
import cc.tucci.admin.app.system.dto.query.SysRoleQuery;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author tucci
 */
@RestController
@RequestMapping("sys/role")
public class SysRoleController {

    private final SysRoleAppService sysRoleAppService;

    public SysRoleController(SysRoleAppService sysRoleAppService) {
        this.sysRoleAppService = sysRoleAppService;
    }

    /**
     * 查询角色列表
     */
    @RequiresPermissions(value = {"sys:role:list", "sys:user:create", "sys:user:update"}, logical = Logical.OR)
    @GetMapping
    public Response list(SysRoleQuery query) {
        return sysRoleAppService.list(query);
    }

    /**
     * 添加角色
     */
    @Operate("添加角色")
    @RequiresPermissions(value = {"sys:role:create"})
    @PostMapping
    public Response create(@Valid @RequestBody SysRoleCreateBody body) {
        return sysRoleAppService.create(body);
    }

    /**
     * 修改角色
     */
    @Operate("修改角色")
    @RequiresPermissions(value = {"sys:role:update"})
    @PutMapping
    public Response update(@Valid @RequestBody SysRoleUpdateBody body) {
        return sysRoleAppService.update(body);
    }

    /**
     * 删除角色
     */
    @Operate("删除角色")
    @DeleteMapping("{id}")
    public Response delete(@PathVariable Long id) {
        return sysRoleAppService.delete(id);
    }

    /**
     * 查询角色关联的资源id
     */
    @RequiresPermissions(value = {"sys:role:list"}, logical = Logical.OR)
    @GetMapping("res/{id}")
    public Response listResId(@PathVariable Long id) {
        return sysRoleAppService.listResIdById(id);
    }

    /**
     * 修改角色关联的资源
     */
    @Operate("修改角色关联的资源")
    @RequiresPermissions(value = {"sys:role:update"})
    @PutMapping("res")
    public Response updateRes(@Valid @RequestBody SysRoleUpdateResBody body) {
        return sysRoleAppService.updateRes(body);
    }
}
