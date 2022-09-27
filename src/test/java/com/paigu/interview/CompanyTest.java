package com.paigu.interview;

import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.paigu.interview.dto.DepartmentTreeDTO;
import com.paigu.interview.entity.Department;
import com.paigu.interview.entity.Employee;
import com.paigu.interview.service.IDepartmentService;
import com.paigu.interview.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class CompanyTest {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;


    @Test
    void findEmployee() {
        System.out.println(employeeService.list());
    }

    @Test
    void findDepartment(){
        System.out.println(departmentService.list());
    }


    @Test
    void hutoolTree() {
        List<TreeNode<Integer>> treeNodes = new ArrayList<>();
        List<Department> departmentList = departmentService.list();
        List<Employee> employeeList = employeeService.list();
        for (Department department : departmentList) {
            TreeNode<Integer> integerTreeNode = new TreeNode<>(department.getDepartmentId(), department.getDepartmentPid(), department.getDepartmentName(), null);
            Map<String, Object> extra = new HashMap<>();
            extra.put("地址", department.getDepartmentAddress());
            integerTreeNode.setExtra(extra);
            treeNodes.add(integerTreeNode);
        }
        System.out.println(TreeUtil.build(treeNodes));
    }

    /**
     * 构建树
     */
    @Test
    void buildTree(){
        List<DepartmentTreeDTO> departmentTreeDTOList = new ArrayList<>();
        List<Department> departmentList = departmentService.list();
        List<Employee> employeeList = employeeService.list();
        for (Department department : departmentList) {
            departmentTreeDTOList.add(new DepartmentTreeDTO(department));
        }

        DepartmentTreeDTO rootNode = null;
        for (DepartmentTreeDTO node : departmentTreeDTOList) {
            if (Objects.equals(node.getParentId(), 0)) {
                rootNode = node;
            }
            this.findChildren(departmentTreeDTOList, node);
        }
        System.out.println(rootNode);
    }

    void findChildren(List<DepartmentTreeDTO> departmentTreeDTOList, DepartmentTreeDTO node) {
        for (DepartmentTreeDTO departmentTreeDTO : departmentTreeDTOList) {
            if (Objects.equals(departmentTreeDTO.getParentId(), node.getId())) {
//                node.addChildNode(departmentTreeDTO);
            }
        }
    }
}
