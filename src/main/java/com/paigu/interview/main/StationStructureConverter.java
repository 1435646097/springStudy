package com.paigu.interview.main;
import java.util.*;

public class StationStructureConverter {

    // 节点类
    static class StructureNode {
        int structureId;
        int parentStructureId;
        String structureName;
        String levelPath;
        String namePath; // 转换后的名称路径

        public StructureNode(int structureId, int parentStructureId, String structureName, String levelPath) {
            this.structureId = structureId;
            this.parentStructureId = parentStructureId;
            this.structureName = structureName;
            this.levelPath = levelPath;
        }
    }

    public static void main(String[] args) {
        // 模拟从数据库查询的数据（实际应用中应从数据库查询）
        List<StructureNode> nodes = Arrays.asList(
                new StructureNode(571, 0, "杭州移动S6V26中心", "571"),
                new StructureNode(571000001, 571, "未分组局站", "571.571000001"),
                new StructureNode(571000002, 571, "未分组局站", "571.571000002"),
                new StructureNode(571000003, 571, "未分组局站", "571.571000003"),
                new StructureNode(571000004, 571, "余杭区", "571.571000004"),
                new StructureNode(571000005, 571000004, "科技城", "571.571000004.571000005"),
                new StructureNode(571000006, 571, "萧山区", "571.571000006"),
                new StructureNode(571000007, 571000006, "奥运新城", "571.571000006.571000007"),
                new StructureNode(571000009, 571000006, "机场区", "571.571000006.571000009"),
                new StructureNode(571000010, 571000006, "高新区", "571.571000006.571000010"),
                new StructureNode(571000011, 571, "上城区", "571.571000011"),
                new StructureNode(571000012, 571, "西湖区", "571.571000012"),
                new StructureNode(571000013, 571000012, "省府街道", "571.571000012.571000013")
        );

        // 构建树形结构
        Map<Integer, StructureNode> nodeMap = new HashMap<>();
        for (StructureNode node : nodes) {
            nodeMap.put(node.structureId, node);
        }

        // 递归构建NamePath (从每个节点开始递归)
        for (StructureNode node : nodes) {
            buildNamePath(node, nodeMap);
        }

        // 输出结果
        for (StructureNode node : nodes) {
            System.out.println("StructureId: " + node.structureId +
                    ", StructureName: " + node.structureName +
                    ", NamePath: " + node.namePath);
        }
    }

    // 递归构建NamePath的方法
    private static void buildNamePath(StructureNode node, Map<Integer, StructureNode> nodeMap) {
        if (node.namePath != null) {
            return; // 已经构建过，避免重复构建
        }
        if (node.parentStructureId == 0) {
            node.namePath = node.structureName;
        } else {
            StructureNode parentNode = nodeMap.get(node.parentStructureId);
            if (parentNode == null) {
                System.err.println("Error: Parent node not found for StructureId: " + node.structureId);
                return;
            }
            if (parentNode.namePath == null) {
                buildNamePath(parentNode, nodeMap); // 先构建父节点的NamePath
            }
            node.namePath = parentNode.namePath + "." + node.structureName;
        }
    }
}

