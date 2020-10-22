/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author BOT
 */
public class Student {
    private String name;
    private boolean gender;
    private String queQuan;
    private Date ngaySinh;
    private String maSv;
    private String lop;
    private String khoa;
    private String nganh;
    private byte[] image;

    public Student() {
    }

    public Student(String name, boolean gender, String queQuan, Date ngaySinh, String maSv, String lop, String khoa, String nganh, byte[] image) {
        this.name = name;
        this.gender = gender;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.maSv = maSv;
        this.lop = lop;
        this.khoa = khoa;
        this.nganh = nganh;
        this.image = image;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
    
    
    
    
}
