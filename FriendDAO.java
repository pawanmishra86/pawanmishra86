package layer3;

import java.util.ArrayList;

import layer2.Friend;

public interface FriendDAO { //DATA ACCESS OBJECt | Repository
	//5 functions - CRUD
	void 			  insertFriend(Friend friend);
	void 			  updateFriend(Friend friend);
	void 			  deleteFriend(int friendId);
	Friend 			  selectFriend(int friendId);
	ArrayList<Friend> selectAllFriends();
	
	
}
/*
		Book b1 = new Book(123,"Java11",1500.0,"James G");
		Book b2 = b1;
		
		Book b3 = new Book(123,"Java11",1500.0,"James G");
		
		hint : equals and hashCode to be overrriden or not?
		
*/