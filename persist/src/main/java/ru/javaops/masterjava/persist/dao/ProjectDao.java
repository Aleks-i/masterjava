package ru.javaops.masterjava.persist.dao;

import com.bertoncelj.jdbi.entitymapper.EntityMapperFactory;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import ru.javaops.masterjava.persist.model.Project;

@RegisterMapperFactory(EntityMapperFactory.class)
public abstract class ProjectDao implements AbstractDao {

    public Project insert(Project project) {
        if (project.isNew()) {
            int id = insertGeneratedId(project);
            project.setId(id);
        } else {
            insertWitId(project);
        }
        return project;
    }

    @SqlUpdate("INSERT INTO projects (name, description) VALUES (:name, :description)" +
            "ON CONFLICT DO NOTHING")
    @GetGeneratedKeys
    abstract int insertGeneratedId(@BindBean Project project);

    @SqlUpdate("INSERT INTO projects (id, name, description) VALUES (:name, :description)" +
            "ON CONFLICT DO NOTHING")
    abstract void insertWitId(@BindBean Project project);

    @SqlQuery("SELECT * FROM projects WHERE projects.id = :id")
    public abstract Project getProjectById(@Bind("id") Integer id);

    @SqlUpdate("TRUNCATE projects CASCADE")
    @Override
    public abstract void clean();

    @SqlUpdate("ALTER SEQUENCE common_seq RESTART")
    public abstract void restartCommSeq();
}
