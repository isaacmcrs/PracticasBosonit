package com.bosonit.block10dockerizeapp.rowMapper;

import com.bosonit.block10dockerizeapp.model.Empleado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoRowMapper implements RowMapper<Empleado> {

    @Override
    public Empleado mapRow(ResultSet rs, int arg1) throws SQLException {
        Empleado emp = new Empleado();
        emp.setEmpleadoId(rs.getString("employeeId"));
        emp.setEmpleadoNombre(rs.getString("employeeName"));
        emp.setEmpleadoEmail(rs.getString("employeeEmail"));

        return emp;
    }


}