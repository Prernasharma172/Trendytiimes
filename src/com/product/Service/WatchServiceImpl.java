package com.product.Service;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.product.entity.Watch;
import com.product.utility.DBConnection;

public class WatchServiceImpl implements WatchService{
		
		Connection con=null;
		String sql=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
	
	@Override
	public boolean addWatch(Watch w) {
		
		try {
			
			con=DBConnection.makeConnection();
			sql="insert into watches values(?, ?, ?, ?, ?, ? )";
			ps=con.prepareStatement(sql);
			ps.setString(1, w.getwatchId());
			ps.setString(2, w.getwatchName());
			ps.setString(3, w.getbrand());
			ps.setString(4, w.getCategory());
			ps.setDouble(5, w.getPrice());
			ps.setInt(6, w.getQuantityInstock());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean updateWatch(Watch w) {
		
		con=DBConnection.makeConnection();
		sql="update watches set watchName=?, brand=?, category=?, price=?, quantityInstock=? where watchId=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(6, w.getwatchId());
			ps.setString(1, w.getwatchName());
			ps.setString(2, w.getbrand());
			ps.setString(3, w.getCategory());
			ps.setDouble(4, w.getPrice());
			ps.setInt(5, w.getQuantityInstock());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteWatch(Watch w) {
		con=DBConnection.makeConnection();
		sql="delete from watches where watchId=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, w.getwatchId());
			
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public Watch getWatchById(String watchId) {
		
		con=DBConnection.makeConnection();
		sql="select * from watches where watchId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, watchId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Watch w=new Watch();
				w.setwatchId(rs.getString("watchId"));
				w.setwatchName(rs.getString("watchName"));
				w.setCategory(rs.getString("category"));
				w.setbrand(rs.getString("brand"));
				w.setPrice(rs.getDouble("price"));
				w.setQuantityInstock(rs.getInt("quantityInstock"));
				
				
				return w;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Watch> showAllwatch() {
		
		try {
			con=DBConnection.makeConnection();
			sql="select * from watches";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			List<Watch> wlist=new ArrayList<Watch>();
			
			while(rs.next()) {
				
				Watch w=new Watch();
				w.setwatchId(rs.getString("watchId"));
				w.setwatchName(rs.getString("watchName"));
				w.setCategory(rs.getString("category"));
				w.setbrand(rs.getString("brand"));
				w.setPrice(rs.getDouble("price"));
				w.setQuantityInstock(rs.getInt("quantityInstock"));
				
				wlist.add(w);
			}
			
			return wlist;
			
		}
		catch(Exception e) {
			
		}
		
		return null;
	}

	@Override
	public List<Watch> getWatchByCategory(String category) {

		return null;
	}

	@Override
	public List<Watch> getWatchByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
