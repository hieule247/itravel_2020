package itravel.model;


import java.util.*;
import java.util.stream.Collectors;

public class Data {
    private List<User> users;
    private List<_Post> _posts;
    private List<CommentPost> comments;
    private List<Follow> follows;
    private List<WordFilter> wordFilters;

    private List<Book> books;
    private List<Post> posts;
    private ArrayList<Member> members;
    private Page<User> page = new Page<>();

    public Data(){
        users   = new ArrayList<>();
        _posts  = new ArrayList<>();
        comments  = new ArrayList<>();
        follows  = new ArrayList<>();
        wordFilters  = new ArrayList<>();

        books   = new ArrayList<>();
        members = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public Page<User> getPage() {
        return page;
    }

    public  Page<User> page(int pageNo, int pageSize) {
        List<User> deactivUserList = getDeactivUserList();
        //核心是给page中的五个属性一一赋值

        //Page<User> page = new Page<>();

        // 设置每页显示的数量
        //page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = deactivUserList.size();
        // 设置总记录数
        //page.setPageTotalCount(pageTotalCount);
        // 求总页码
        //Integer pageTotal = pageTotalCount / pageSize;
        //if (pageTotalCount % pageSize > 0) {
        // pageTotal+=1;
        // }
        // 设置总页码
        //page.setPageTotal(pageTotal);

        // 设置当前页码
        //page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        //int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据


        List<User> onePageUsers  = new LinkedList<>();
        onePageUsers = deactivUserList.subList(pageNo,pageSize);
        // 设置当前页数据
        page.setItems(onePageUsers);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        System.out.println("DATA: "+ page.getPageNo()+"DATA: "+page.getPageSize());

        return page;
    }


    // ------------------- User Management
    public List<User> getUserList(){
        return users;
    }

    public User getUser(String id){
        return users.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getUserIdx(String id){
        for (int i=0; i < users.size(); i++){
            if (users.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public User addUser(String id, String userType, String fullName, String gender, String state, String city, String street,
                        String zipCode, Integer birthYear, String email, String password){
        users.add(new User(id, userType, fullName, gender, state, city, street, zipCode, birthYear, email, password));
        return null;
    }

    public void updUser(String id, String userType, String fullName, String gender, String state, String city, String street,
                        String zipCode, Integer birthYear, String email, String password){
        int curIdx = getUserIdx(id);
        User curUser = getUser(id);

        curUser.setUserType(userType);
        curUser.setFullName(fullName);
        curUser.setGender(gender);
        curUser.setState(state);
        curUser.setCity(city);
        curUser.setStreet(street);
        curUser.setZipCode(zipCode);
        curUser.setBirthYear(birthYear);
//        curUser.setEmail(email); // Do not update email
        curUser.setPassword(password);
        // Update
        users.set(curIdx, curUser);
    }



    public void delUser(String id){
        int idx = getUserIdx(id);
        if (idx != -1)
            users.remove(idx);
    }

    public List<User> searchUser(String name){
        return users.parallelStream()
                .filter(b -> b.getId().toLowerCase().contains(name.toLowerCase())
                        || b.getFullName().toLowerCase().contains(name.toLowerCase())
                        || b.getState().toLowerCase().contains(name.toLowerCase())
                        || b.getStreet().toLowerCase().contains(name.toLowerCase())
                        || b.getCity().toLowerCase().contains(name.toLowerCase())
                        || b.getZipCode().toLowerCase().contains(name.toLowerCase())
                        || b.getEmail().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public User getUserByEmail(String email){
        // return users.parallelStream().filter(b -> b.getEmail().equals(email)).findAny().orElse(null);
        for (int i=0; i<users.size(); i++)
        {
            User item = users.get(i);
            if (item.getEmail().equals(email))
                return item;
        }
        // Not found
        return null;
    }

    public User login(String userName, String password){
        User item = getUserByEmail(userName);
        if (item != null){
            if (password.equals(item.getPassword())){
                return item;
            }
        }
        // Not found or login error
        return null;
    }
//post mn
    public List<Post> getPostList() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public int getPostIdx(String id){
        for (int i=0; i < posts.size(); i++){
            if (posts.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }


    public void addPost(String id, String userId, String image, String title, String content, String category, String tags, String time){
        posts.add(new Post(id, userId, image, title, content, category, tags, time));

    }
    public Post getPost(String id){
        return posts.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public void updPost(String id, String userId, String image, String title, String content, String category, String tags, String time){
        int curIdx = getPostIdx(id);
        Post curPost = getPost(id);
        curPost.setContent(content);
        curPost.setImage(image);
        curPost.setTitle(title);
        curPost.setCategory(category);
        curPost.setTags(tags);
        curPost.setDate(time);

        // Update
        posts.set(curIdx, curPost);
    }

    public void delPost(String id){
        int idx = getPostIdx(id);
        if (idx != -1)
            users.remove(idx);
    }

    public List<Post> searchPost(String name){

        return posts.parallelStream()
                .filter(b -> b.getTitle().toLowerCase().contains(name.toLowerCase())
                        || b.getContent().toLowerCase().contains(name.toLowerCase())
                        ||b.getCategory().toLowerCase().contains(name.toLowerCase())
                        ||b.getTags().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

    }
    public List<Post> findPostsByUserId(String userId){
        //List<Post> list = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        for (Post b : posts) {
            if (b.getUserId() == userId) {
                postList.add(b);

            }
        }
        return postList;
    }

    // ------------------- _Post Management
    public List<_Post> get_PostList(){
        return _posts;
    }

    public _Post get_Post(String id){
        return _posts.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int get_PostIdx(String id){
        for (int i=0; i < _posts.size(); i++){
            if (_posts.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void add_Post(String id, String userId, String image, String title, String content, String category, String tags){
        _posts.add(new _Post(id, userId, image, title, content, category, tags));
    }

    public void upd_Post(String id, String userId, String image, String title, String content, String category, String tags){
        int curIdx = get_PostIdx(id);
        _Post cur_Post = get_Post(id);

        cur_Post.setImage(image);
        cur_Post.setTitle(title);
        cur_Post.setContent(content);
        cur_Post.setCategory(category);
        cur_Post.setTags(tags);
        // Update
        _posts.set(curIdx, cur_Post);
    }

    public void del_Post(String id){
        int idx = get_PostIdx(id);
        if (idx != -1)
            _posts.remove(idx);
    }

    public List<_Post> search_Post(String name){
        return _posts.parallelStream()
                .filter(b -> b.getTitle().toLowerCase().contains(name.toLowerCase())
                        || b.getContent().toLowerCase().contains(name.toLowerCase())
                        || b.getCategory().toLowerCase().contains(name.toLowerCase())
                        || b.getTags().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ------------------- Comment Management
    public List<CommentPost> getCommentList(){
        return comments;
    }

    public CommentPost getComment(String id){
        return comments.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getCommentIdx(String id){
        for (int i=0; i < comments.size(); i++){
            if (comments.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addComment(String id, String postId, String userId, String content){
        comments.add(new CommentPost(id, postId, userId, content));
    }

    public void updComment(String id, String postId, String userId, String content){
        int curIdx = getCommentIdx(id);
        CommentPost curComment = getComment(id);

        curComment.setPostId(postId);
        curComment.setUserId(userId);
        curComment.setContent(content);
        // Update
        comments.set(curIdx, curComment);
    }

    public void delComment(String id){
        int idx = getCommentIdx(id);
        if (idx != -1)
            comments.remove(idx);
    }

    public List<CommentPost> searchComment(String name){
        return comments.parallelStream()
                .filter(b -> b.getId().toLowerCase().contains(name.toLowerCase())
                        || b.getPostId().toLowerCase().contains(name.toLowerCase())
                        || b.getUserId().toLowerCase().contains(name.toLowerCase())
                        || b.getContent().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ------------------- Follow Management
    public List<Follow> getFollowList(){
        return follows;
    }

    public Follow getFollow(String id){
        return follows.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getFollowIdx(String id){
        for (int i=0; i < follows.size(); i++){
            if (follows.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addFollow(String id, String travellerId, String userId){
        follows.add(new Follow(id, travellerId, userId));
    }

    public void updFollow(String id, String travellerId, String userId){
        int curIdx = getFollowIdx(id);
        Follow curFollow = getFollow(id);

        curFollow.setTravellerId(travellerId);
        curFollow.setUserId(userId);
        // Update
        follows.set(curIdx, curFollow);
    }

    public void delFollow(String id){
        int idx = getFollowIdx(id);
        if (idx != -1)
            follows.remove(idx);
    }

    public List<Follow> searchFollow(String name){
        return follows.parallelStream()
                .filter(b -> b.getId().toLowerCase().contains(name.toLowerCase())
                        || b.getTravellerId().toLowerCase().contains(name.toLowerCase())
                        || b.getUserId().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ------------------- Follow Management
    public List<WordFilter> getWordFilterList(){
        return wordFilters;
    }

    public WordFilter getWordFilter(String id){
        return wordFilters.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getWordFilterIdx(String id){
        for (int i=0; i < wordFilters.size(); i++){
            if (wordFilters.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addWordFilter(String id, String value){
        wordFilters.add(new WordFilter(id, value));
    }

    public void updWordFilter(String id, String value){
        int curIdx = getWordFilterIdx(id);
        WordFilter curItem = getWordFilter(id);

        curItem.setValue(value);
        // Update
        wordFilters.set(curIdx, curItem);
    }

    public void delWordFilter(String id){
        int idx = getWordFilterIdx(id);
        if (idx != -1)
            wordFilters.remove(idx);
    }

    public List<WordFilter> searchWordFilter(String name){
        return wordFilters.parallelStream()
                .filter(b -> b.getId().toLowerCase().contains(name.toLowerCase())
                        || b.getValue().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ------------------- Book Management
    public List<Book> getBookList(){
        return books;
    }

    public Book getBook(String id){
        return books.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getBookIdx(String id){
        for (int i=0; i < books.size(); i++){
            if (books.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addBook(String id, String title, String author, String subject, String isbn){
        books.add(new Book(id, title, author, subject, isbn));
    }

    public void updBook(String id, String title, String author, String subject, String isbn){
        int curIdx = getBookIdx(id);
        Book curBook = getBook(id);

        curBook.setTitle(title);
        curBook.setAuthor(author);
        curBook.setSubject(subject);
        curBook.setIsbn(isbn);
        // Update
        books.set(curIdx, curBook);
    }

    public void delBook(String id){
        int idx = getBookIdx(id);
        if (idx != -1)
            books.remove(idx);
    }

    public List<Book> searchBook(String name){
        return books.parallelStream()
                .filter(b -> b.getTitle().toLowerCase().contains(name.toLowerCase())
                        || b.getAuthor().toLowerCase().contains(name.toLowerCase())
                        || b.getIsbn().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ------------------- Member Management
    public List<Member> getMemberList(){
        return members;
    }

    public Member getMember(String id){
        return members.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getMemberIdx(String id){
/*
        return Integer.parseInt(members.parallelStream()

                .map(b -> b.getId())
                .filter(i -> i.equals(id)).findAny()
                .orElse("-1"));
 */
        for (int i=0; i < members.size(); i++){
            if (members.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addMember(String id, String name, String address, String phone){
        members.add(new Member(id, name, address, phone));
    }

    public void updMember(String id, String name, String address, String phone){
        int curIdx = getMemberIdx(id);
        Member curMem = getMember(id);

        curMem.setName(name);
        curMem.setAddress(address);
        curMem.setPhone(phone);
        // Update
        members.set(curIdx, curMem);
    }

    public void delMember(String id){
        int idx = getMemberIdx(id);
        if (idx != -1)
            members.remove(idx);
    }

    public List<Member> searchMember(String name){
        return members.parallelStream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase())
                        || m.getAddress().toLowerCase().contains(name.toLowerCase())
                        || m.getPhone().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<User> getDeactivUserList(){
        List<User> deactivUserList = new ArrayList<>();
        for(User user : users){
            if(user.getActivType()== false)
                deactivUserList.add(user);
        }
        return deactivUserList;
    }

    public void updUserStates(String id, boolean status){
        int curIdx = getUserIdx(id);
        User curUser = getUser(id);

        curUser.setActivType(status);
        // Update
        users.set(curIdx, curUser);
    }
    public void changeUserActiveType(User user){

        if(user.getActivType() == true){
            user.setActivType(false);
        }else{
            user.setActivType(true);
        }
    }


}
