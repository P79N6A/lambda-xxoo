package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.core.enums.SnapshotTypeEnum;
import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import com.yatop.lambda.workflow.core.richmodel.experiment.ExperimentTemplate;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnapshotHelper {

    private static SnapshotMgr SNAPSHOT_MGR;

    @Autowired
    public void setSnapshotMgr(SnapshotMgr snapshotMgr) {
        SNAPSHOT_MGR = snapshotMgr;
    }

    public static WfSnapshot querySnapshot(Long snapshotId) {
        return SNAPSHOT_MGR.querySnapshot(snapshotId);
    }

    public static Snapshot querySnapshot4View(Long snapshotId) {
        return Snapshot.BuildSnapshot4View(querySnapshot(snapshotId));
    }

    public static Snapshot querySnapshot4Execution(ExecutionJob job) {
        return Snapshot.BuildSnapshot4Execution(querySnapshot(job.data().getRelSnapshotId()), job.enableFlushSnapshot());
    }

    public static Snapshot querySnapshot4ViewExecution(ExecutionJob job) {
        return Snapshot.BuildSnapshot4View(querySnapshot(job.data().getRelSnapshotId()));
    }

    public static Snapshot simulateSnapshot4Template(Project project, ExperimentTemplate template) {
        WfSnapshot data = new WfSnapshot();
        data.setSnapshotId(-1L);
        data.setSnapshotName(template.data().getTemplateName());
        data.setSnapshotType(SnapshotTypeEnum.TEMPLATE.getType());
        data.setOwnerProjectId(project.data().getProjectId());
        data.setOwnerFlowId(-1L);
        data.setSnapshotContent(template.data().getTemplateContent());
        data.setSnapshotVersion(-1L);
        data.setSnapshotState(SnapshotStateEnum.FINISHED.getState());
        data.setDescription(template.data().getDescription());
        data.setStatus(DataStatusEnum.NORMAL.getStatus());
        data.setLastUpdateTime(template.data().getCreateTime());
        data.setLastUpdateOper(template.data().getLastUpdateOper());
        data.setCreateTime(template.data().getCreateTime());
        data.setCreateOper(template.data().getCreateOper());
        return Snapshot.BuildSnapshot4Template(data, project);
    }

    public static void updateSnapshot(Snapshot snapshot, String operId) {
        SNAPSHOT_MGR.updateSnapshot(snapshot.data(), operId);
        snapshot.clearColoured();
    }
}
