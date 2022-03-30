package layer3;

import java.util.ArrayList;
import java.util.List;

import layer2.Friend;

public class FriendDAOImpl implements FriendDAO {

	ArrayList<Friend> friendList = new ArrayList<Friend>();
	
	public FriendDAOImpl() { //simulation of the DB
		System.out.println("FriendDAOImpl() ctor...");	
		friendList.add(new Friend(123,"Shashi","Java Student Friend"));
		friendList.add(new Friend(124,"Deven","Mutual Friend"));
		friendList.add(new Friend(125,"Preeti","Office Friend"));
		friendList.add(new Friend(126,"Jack","Client Friend"));
		friendList.add(new Friend(127,"Jane","Relative Friend"));
	}
	
	@Override
	public void insertFriend(Friend friend) {
		System.out.println("FriendDAOImpl : insertFriend(int)");
		boolean friendFoundOrNot = false;
		Friend foundFriend = null;
		
		for (int i = 0; i < friendList.size(); i++) {
			foundFriend = friendList.get(i);
			if (foundFriend.getFriendId() == friend.getFriendId()) {
				friendFoundOrNot = true;
				break;
			}
		}
		if(friendFoundOrNot == true) {
			FriendAlreadyExistsException friendAlExiEx = new FriendAlreadyExistsException("This friend id is already present : " +friend.getFriendId());
			throw friendAlExiEx;
		}
		else {
			friendList.add(friend);
		}
	}

	@Override
	public void updateFriend(Friend friend) {
		System.out.println("FriendDAOImpl : updateFriend(int)");
		boolean friendFoundOrNot = false;
		Friend foundFriend = null;
		
		for (int i = 0; i < friendList.size(); i++) {
			foundFriend = friendList.get(i);
			if (foundFriend.getFriendId() == friend.getFriendId()) {
				friendFoundOrNot = true;
				friendList.remove(i);
				friendList.add(friend);
				break;
			}
		}
		
		if(friendFoundOrNot == false) {
			FriendNotFoundException friendNotFndEx = new FriendNotFoundException("This friend id not found to modify : "+friend.getFriendId());
			throw friendNotFndEx ;
		}
	}

	@Override
	public void deleteFriend(int friendId) {
		System.out.println("FriendDAOImpl : deleteFriend(int)");
		boolean friendFoundOrNot = false;
		Friend foundFriend = null;
		
		for (int i = 0; i < friendList.size(); i++) {
			foundFriend = friendList.get(i);
			if (foundFriend.getFriendId() == friendId) {
				friendFoundOrNot = true;
				friendList.remove(i);
				break;
			}
		}
		if(friendFoundOrNot == false)
			throw new FriendNotFoundException("Friend not found : "+friendId);

	}

	@Override
	public Friend selectFriend(int friendId) {
		System.out.println("FriendDAOImpl : selectFriend(int)");
		boolean friendFoundOrNot = false;
		Friend foundFriend = null;
		
		for (int i = 0; i < friendList.size(); i++) {
			foundFriend = friendList.get(i);
			if (foundFriend.getFriendId() == friendId) {
				friendFoundOrNot = true;
				break;
			}
		}
		if(friendFoundOrNot == true)
			return foundFriend;
		else
			throw new FriendNotFoundException("This friend not found : "+friendId);
	}

	@Override
	public ArrayList<Friend> selectAllFriends() {
		System.out.println("FriendDAOImpl : selectAllFriends()");
		return friendList;
	}

}
