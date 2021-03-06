package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="user")
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
		Integer user_id;
		String account;
		String password;
		String name;
		String nickname;
		String gender;
		Date birthday;
		String phone;
		String address;
		String photoName;
		Blob photo;
		Clob introduction;
		Timestamp regTime;
		long unpaid_amount;
		
		public UserBean(Integer user_id, String account, String password, String name, String nickname, String gender, Date birthday,
				String phone, String address, Blob photo, String photoName, Clob introduction, Timestamp regTime, long unpaid_amount) 
		{
			super();
			this.user_id = user_id;
			this.account = account;
			this.password = password;
			this.name = name;
			this.nickname = nickname;
			this.gender = gender;
			this.birthday = birthday;
			this.phone = phone;
			this.address = address;
			this.photo = photo;
			this.photoName = photoName;
			this.introduction = introduction;
			this.regTime = regTime;
			this.unpaid_amount = unpaid_amount;
		}
		
		// without photoName
		public UserBean(Integer user_id, String account, String password, String name, String nickname, String gender, Date birthday,
				String phone, String address, Blob photo, Clob introduction, Timestamp regTime, long unpaid_amount) {
			super();
			this.user_id = user_id;
			this.account = account;
			this.password = password;
			this.name = name;
			this.nickname = nickname;
			this.gender = gender;
			this.birthday = birthday;
			this.phone = phone;
			this.address = address;
			this.photo = photo;
			this.introduction = introduction;
			this.regTime = regTime;
			this.unpaid_amount = unpaid_amount;
		}

		// empty Constructor
		public UserBean() {
		}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer getUser_id() {
			return user_id;
		}
		
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		
		
		public String getPhotoName() {
			return photoName;
		}
		
		public void setPhotoName(String photoName) {
			this.photoName = photoName;
		}
		
		public Blob getPhoto() {
			return photo;
		}
		
		public void setPhoto(Blob photo) {
			this.photo = photo;
		}
		
		public Clob getIntroduction() {
			return introduction;
		}
	
		public void setIntroduction(Clob introduction) {
			this.introduction = introduction;
		}
	
		public Timestamp getRegTime() {
			return regTime;
		}

		public void setRegTime(Timestamp regTime) {
			this.regTime = regTime;
		}
		
		public long getUnpaid_amount() {
			return unpaid_amount;
		}
		
		public void setUnpaid_amount(Long unpaid_amount) {
			this.unpaid_amount = unpaid_amount;
		}

}
