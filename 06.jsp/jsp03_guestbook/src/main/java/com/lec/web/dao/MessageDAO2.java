package com.lec.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lec.web.model.Message;

public class MessageDAO2 {

	private MessageDAO2() {}
	
	private static MessageDAO2 messageDAO2 = new MessageDAO2();
	public static MessageDAO2 getInstance() { return messageDAO2; }
	
	public List<Message> selectList(Connection conn, int start, int end) {
		
		List<Message> messageList1 = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				do {
					messageList1.add(makeMessage(rs));
					
				} while(rs.next());

			} else {
				return Collections.emptyList();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageList1;
	}

	public Message makeMessage(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		
		return message;
	}
}
