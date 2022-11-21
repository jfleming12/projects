package com.revature.dao;

import com.revature.model.Superhero;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroDaoImpl implements SuperHeroDao{

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Superhero save(Superhero superhero) {
        // Use prepared statement to prevent SQL injection
        String sql = "insert into superhero values(default, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3, superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());

            // this will actually execute the statement
            int count = preparedStatement.executeUpdate();

            // if count is 1, that means success, we've updated the table:
            if(count == 1) {
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Superhero> findAllSuperheroes() {

		Statement stmt = null;
		ResultSet set = null;

		List<Superhero> superheroes = new ArrayList<>();
		
		final String SQL = "select * from superhero";
		
		try {
			
			stmt = connection.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {

				Superhero superhero = new Superhero(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getInt(4),
						set.getString(5),
						set.getString(6),
						set.getString(7));
				
				superheroes.add(superhero);
				 
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return superheroes;
	}
    
    public Superhero findById(int id) {
		
		Superhero superhero = null;

		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from superhero where id = ?";
		
		try {
			stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();

			if(set.next()) {
				superhero = new Superhero(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getInt(4),
						set.getString(5),
						set.getString(6),
						set.getString(7));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return superhero;
	}

    public Superhero update(Superhero superhero) {
        // Use prepared statement to prevent SQL injection
        String sql = "UPDATE superhero SET superhero_name = ?, super_power = ?, strength = ?, weakness = ?,"
        		+ " franchise = ?, world = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3, superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());
            preparedStatement.setInt(7, superhero.getId());

            // this will actually execute the statement
            int count = preparedStatement.executeUpdate();

            // if count is 1, that means success, we've updated the table:
            if(count == 1) {
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void delete(int id) {
		

		PreparedStatement stmt = null;
		final String SQL = "delete from superhero where id = ?";
		
		try {
			stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

    public Superhero findBystrength(int str) {
		
		Superhero superhero = null;

		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from superhero where strength = ?";
		
		try {
			stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, str);
			set = stmt.executeQuery();

			if(set.next()) {
				superhero = new Superhero(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getInt(4),
						set.getString(5),
						set.getString(6),
						set.getString(7));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return superhero;
	}
    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)
}
