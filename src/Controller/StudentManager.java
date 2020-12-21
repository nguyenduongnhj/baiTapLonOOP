/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnector;
import Model.MonHoc;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BOT
 */
public class StudentManager {
    
    Connection conn;
    
    public StudentManager()  throws SQLException, ClassNotFoundException, Exception{
        DBConnector db = new DBConnector();
        this.conn = db.getConnect();
    }
    
    
    
    public List<Student> getListStudent() throws SQLException{
        List<Student> list = new ArrayList<>();
        String query = "select sv.hoten, sv.maSv from sinhvien sv";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        Student s = null;
        while(rs.next()){
            s = new Student();
            s.setName(rs.getString("hoten"));
            s.setMaSv(rs.getString("maSv"));
            list.add(s);

        }
        return list;
    }
    
    public Student getDetail(String maSv) throws SQLException{
        String query = "select * from QLSV.dbo.sinhvien sv where sv.masv = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, maSv);
        ResultSet rs = pstmt.executeQuery();
        Student s = null;
        while(rs.next()){
            s = new Student(rs.getString("hoten"), rs.getBoolean("gioitinh"), rs.getString("queQuan"), rs.getDate("Ngaysinh"), maSv, rs.getString("lop"), rs.getString("khoahoc"), rs.getString("nganhhoc"), rs.getBytes("anh"));
        }
        return s;
    }
    
    public List<MonHoc> getListSubject() throws SQLException{
        List<MonHoc> list = new ArrayList<>();
        String query = "select mh.tenmonhoc, mh.mamonhoc from monhoc mh";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        MonHoc m = null;
        while(rs.next()){
            m = new MonHoc();
            m.setMaMonHoc(rs.getString("mamonhoc"));
            m.setTenMonHoc(rs.getString("tenmonhoc"));
            list.add(m);
        }
        return list;
    }
    
    public int login(String userName, String pass) throws SQLException{
        String query = "select job from QLSV.dbo.account where userName = ? and pass = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        int job = 0;
        pstmt.setString(1, userName);
        pstmt.setString(2, pass);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            job = rs.getInt("job");
            return job;
        }
        return job;
    }
    
    public boolean addStudent(String ten, String maSv , String lop, Date ngaySinh, boolean gioiTinh, String queQuan, String nganhhoc, String khoaHoc) throws SQLException{
        String query = "select masv from sinhvien where masv = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1,maSv);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return false;
        }else {
            int gt;
            if(gioiTinh){
                gt = 1;
            }else {
                gt = 0;
            } 
            Date date = new Date();
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
            String stringDate= DateFor.format(ngaySinh);
            String query2 = "INSERT INTO QLSV.dbo.sinhvien (maSv, hoten, ngaysinh, gioitinh, quequan, nganhhoc, khoahoc, lop)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt2 = this.conn.prepareStatement(query2);

            pstmt2.setString(1, maSv);
            pstmt2.setString(2, ten);
            pstmt2.setString(3, stringDate);
            pstmt2.setBoolean(4, gioiTinh);
            pstmt2.setString(5, queQuan);
            pstmt2.setString(6, nganhhoc);
            pstmt2.setString(7, khoaHoc);
            pstmt2.setString(8, lop);
            pstmt2.execute();
            
            String query3 = "INSERT INTO QLSV.dbo.account VALUES (?, ?, 1) ";
            PreparedStatement pstmt3 = this.conn.prepareStatement(query3);
            pstmt3.setString(1, maSv);
            pstmt3.setString(2, stringDate);
            pstmt3.execute();
            
            return true;
        }
    }
    
    public boolean deleteStudent(String maSv) throws SQLException{
        String query = "DELETE FROM dbo.sinhvien  WHERE maSv=?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, maSv);
        pstmt.execute();
        
        String query1 = "DELETE FROM dbo.account WHERE userName =?;";
        PreparedStatement pstmt1 = this.conn.prepareStatement(query1);
        pstmt1.setString(1, maSv);
        pstmt1.execute();
        return true; 
    }
    
    public boolean updateStudent(String ten, String maSv, Date ngaySinh, boolean gioiTinh, String queQuan, byte[] image) throws SQLException{
        int gt;
        if(gioiTinh){
            gt = 1;
        } else {
            gt = 0;
        }
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate= DateFor.format(ngaySinh);
        System.out.println("abc "+stringDate);
        String query = "UPDATE QLSV.dbo.sinhvien SET hoten = ?, ngaysinh = ? , gioitinh = ?, quequan = ?, anh = ? WHERE masv=?;";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, ten);
        pstmt.setString(2, stringDate);
        pstmt.setInt(3, gt);
        pstmt.setString(4, queQuan);
        pstmt.setBytes(5, image);
        pstmt.setString(6, maSv);

        pstmt.execute();
        return true;
    }
    
    public boolean nhapDiem(boolean check, float diem, String maMon, String maSv) throws SQLException{
        if(check){
            String query = "UPDATE QLSV.dbo.diemthi SET diem = ? WHERE mamonhoc = ? and maSv=?;";
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setFloat(1,diem);
            pstmt.setString(2,maMon);
            pstmt.setString(3,maSv);
            pstmt.execute();
        } else {
            String query2 = "INSERT INTO QLSV.dbo.diemthi (mamonhoc, masv, diem) VALUES (?, ?, ?);";
            PreparedStatement pstmt2 = this.conn.prepareStatement(query2);
            pstmt2.setString(1,maMon);
            pstmt2.setString(2,maSv);
            pstmt2.setFloat(3,diem);
            pstmt2.execute();
        }
        return true;
    }
    
    
    public List<MonHoc> getListDiem(String maSv) throws SQLException{
        List<MonHoc> list = new ArrayList<>();
        String query = "select mh.mamonhoc, mh.tenmonhoc, diem from diemthi dt, monhoc mh where dt.maSv = ? and mh.mamonhoc = dt.mamonhoc";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, maSv);
        ResultSet rs = pstmt.executeQuery();
        MonHoc m = null;
        while(rs.next()){
            m = new MonHoc(rs.getString("mamonhoc"), rs.getString("tenmonhoc"), rs.getFloat("diem"));
            list.add(m);
        }
        return list;
    }
    
    
    public boolean changePass(String maSv, String pass) throws SQLException{
        String query = "UPDATE QLSV.dbo.account SET pass = ? WHERE userName = ?;";
        PreparedStatement pstmt = this.conn.prepareStatement(query);

        pstmt.setString(1, pass);
        pstmt.setString(2, maSv);
        pstmt.execute();
        return true;
    }
    
    public String getPass(String maSv) throws SQLException{
        String pass = "";
        String query = "select pass from QLSV.dbo.account where userName = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, maSv);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            pass = rs.getString("pass");
            return pass;
        }

        return null;
    }
    
    public boolean themMon(String tenMon, String maMon) throws SQLException{
        String query = "select * from monhoc where mamonhoc = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1,maMon);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return false;
        } else {
            String query2 = "INSERT INTO QLSV.dbo.monhoc (mamonhoc, tenmonhoc) VALUES (?, ?);";
            PreparedStatement pstmt2 = this.conn.prepareStatement(query2);
            pstmt2.setString(1,tenMon);
            pstmt2.setString(2,maMon);
            pstmt2.execute();
            return true;
        }
    }
    
    public List<Student> search(String name) throws SQLException{
        List<Student> list = new ArrayList<>();
        String query = "select hoten, maSv from sinhvien where hoten like N'%"+ name+"%'";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
//        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        Student s = null;
        while(rs.next()){
            s = new Student();
            s.setName(rs.getString("hoten"));
            s.setMaSv(rs.getString("maSv"));
            list.add(s);    
        }
        return list;
    }
    
    public void deleteMon(String maMon) throws SQLException{
        String query = "delete  from QLSV.dbo.diemthi where mamonhoc = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, maMon);
        pstmt.execute();
        
        String query2 = "delete  from QLSV.dbo.monhoc where mamonhoc = ?";
        PreparedStatement pstmt2 = this.conn.prepareStatement(query2);
        pstmt2.setString(1, maMon);
        pstmt2.execute();

    }
    
    
    
    
    
    
    
}
