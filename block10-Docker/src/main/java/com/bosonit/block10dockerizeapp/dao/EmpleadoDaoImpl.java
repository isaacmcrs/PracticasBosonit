package com.bosonit.block10dockerizeapp.dao;

import com.bosonit.block10dockerizeapp.rowMapper.EmpleadoRowMapper;
import com.bosonit.block10dockerizeapp.model.Empleado;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {
    public EmpleadoDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Empleado> findAll() {
        return template.query("select * from Empleado", new EmpleadoRowMapper());
    }
    @Override
    public void meterEmpleado(Empleado emp) {
        final String sql = "insert into Empleado(empleadoId, empleadoNombre , EmpleadoEmail,EmpleadoDireccion) values(:empleadoId,:empleadoNombre,:EmpleadoEmail,:EmpleadoDireccion)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("empleadoId", emp.getEmpleadoId())
                .addValue("empleadoNombre", emp.getEmpleadoNombre())
                .addValue("EmpleadoEmail", emp.getEmpleadoEmail())
                .addValue("EmpleadoDireccion", emp.getEmpleadoDireccion());
        template.update(sql,param, holder);

    }
    @Override

    public void modificarEmpleado(Empleado emp) {
        final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("empleadoId", emp.getEmpleadoId())
                .addValue("empleadoNombre", emp.getEmpleadoNombre())
                .addValue("EmpleadoEmail", emp.getEmpleadoEmail())
                .addValue("EmpleadoDireccion", emp.getEmpleadoDireccion());
        template.update(sql,param, holder);

    }

    @Override
    public void EjecutarActualizarEmpleado(Empleado emp) {
        final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("empleadoId", emp.getEmpleadoId());
        map.put("empleadoNombre", emp.getEmpleadoNombre());
        map.put("EmpleadoEmail", emp.getEmpleadoEmail());
        map.put("EmpleadoDireccion", emp.getEmpleadoDireccion());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }

    @Override
    public void borrarEmpleado(Empleado emp) {
        final String sql = "delete from employee where employeeId=:employeeId";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("EmpleadoId", emp.getEmpleadoId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }

}

