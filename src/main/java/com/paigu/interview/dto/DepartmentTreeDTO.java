package com.paigu.interview.dto;


import cn.hutool.core.lang.tree.TreeNode;
import com.paigu.interview.entity.Department;
import com.paigu.interview.entity.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 部门树dto
 *
 * @author liao
 * @date 2022/09/25
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DepartmentTreeDTO extends TreeNode<Integer> {
    public DepartmentTreeDTO(Department department) {
        super(department.getDepartmentId(),department.getDepartmentPid(),department.getDepartmentName(),null);
//        this.parentId = department.getDepartmentPid();
//        this.name = department.getDepartmentName();
//        this.id = department.getDepartmentId();
    }

    public DepartmentTreeDTO(Employee employee) {
        super(employee.getEmployeeId(),employee.getDepartmentId(),employee.getEmployeeName(),null);
    }

//    /**
//     * 父id
//     */
//    private Integer parentId;
//    /**
//     * id
//     */
//    private Integer id;
//    /**
//     * 名字
//     */
//    private String name;
//    private List<DepartmentTreeDTO> children;
//
//    public List<DepartmentTreeDTO> getChildren() {
//        this.checkChildEmpty();
//        return children;
//    }

//    public void checkChildEmpty(){
//        if (children == null){
//            this.children = new ArrayList<>();
//        }
//    }

//    public void addChildNode(DepartmentTreeDTO departmentTreeDTO){
//        this.checkChildEmpty();
//        children.add(departmentTreeDTO);
//    }
//
//    public DepartmentTreeDTO findNode(DepartmentTreeDTO departmentTreeDTO){
//        this.checkChildEmpty();
//        for (DepartmentTreeDTO child : this.children) {
//            if (Objects.equals(child.getId(), departmentTreeDTO.getId())) {
//                return child;
//            }
//        }
//        return null;
//    }
}
