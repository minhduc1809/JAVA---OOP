import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Class đại diện cho một cuốn sách
class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private int publicationYear;
    private int totalCopies;
    private int availableCopies;
    private int borrowedCopies;
    
    public Book(String bookId, String title, String author, String isbn, 
                String category, int publicationYear, int totalCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.borrowedCopies = 0;
    }
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getCategory() { return category; }
    public int getPublicationYear() { return publicationYear; }
    public int getTotalCopies() { return totalCopies; }
    public int getAvailableCopies() { return availableCopies; }
    public int getBorrowedCopies() { return borrowedCopies; }
    
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
    
    public void setBorrowedCopies(int borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }
    
    public boolean isAvailable() {
        return availableCopies > 0;
    }
    
    public void borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
            borrowedCopies++;
        }
    }
    
    public void returnCopy() {
        if (borrowedCopies > 0) {
            availableCopies++;
            borrowedCopies--;
        }
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d) | Có sẵn: %d/%d", 
                           bookId, title, author, publicationYear, 
                           availableCopies, totalCopies);
    }
}
class Member {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private String membershipType;
    private LocalDate joinDate;
    private boolean isActive;
    private List<String> borrowedBookIds;
    private int maxBooksAllowed;
    
    public Member(String memberId, String name, String email, String phone, 
                  String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipType = membershipType;
        this.joinDate = LocalDate.now();
        this.isActive = true;
        this.borrowedBookIds = new ArrayList<>();
        this.maxBooksAllowed = membershipType.equals("Premium") ? 10 : 5;
    }
    
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getMembershipType() { return membershipType; }
    public LocalDate getJoinDate() { return joinDate; }
    public boolean isActive() { return isActive; }
    public List<String> getBorrowedBookIds() { return borrowedBookIds; }
    public int getMaxBooksAllowed() { return maxBooksAllowed; }
    
    public void setActive(boolean active) { this.isActive = active; }
    
    public boolean canBorrowMore() {
        return borrowedBookIds.size() < maxBooksAllowed;
    }
    
    public void addBorrowedBook(String bookId) {
        if (!borrowedBookIds.contains(bookId)) {
            borrowedBookIds.add(bookId);
        }
    }
    
    public void removeBorrowedBook(String bookId) {
        borrowedBookIds.remove(bookId);
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s | Đang mượn: %d/%d sách", 
                           memberId, name, membershipType, 
                           borrowedBookIds.size(), maxBooksAllowed);
    }
}
class BorrowRecord {
    private String recordId;
    private String memberId;
    private String bookId;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private boolean isReturned;
    private double fineAmount;
    
    public BorrowRecord(String recordId, String memberId, String bookId) {
        this.recordId = recordId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = LocalDateTime.now();
        this.dueDate = borrowDate.plusDays(14); 
        this.returnDate = null;
        this.isReturned = false;
        this.fineAmount = 0.0;
    }
    
    // Getters and Setters
    public String getRecordId() { return recordId; }
    public String getMemberId() { return memberId; }
    public String getBookId() { return bookId; }
    public LocalDateTime getBorrowDate() { return borrowDate; }
    public LocalDateTime getDueDate() { return dueDate; }
    public LocalDateTime getReturnDate() { return returnDate; }
    public boolean isReturned() { return isReturned; }
    public double getFineAmount() { return fineAmount; }
    
    public void setReturnDate(LocalDateTime returnDate) { this.returnDate = returnDate; }
    public void setReturned(boolean returned) { this.isReturned = returned; }
    public void setFineAmount(double fineAmount) { this.fineAmount = fineAmount; }
    
    public double calculateFine(double finePerDay) {
        if (!isReturned && LocalDateTime.now().isAfter(dueDate)) {
            long daysLate = java.time.Duration.between(dueDate, LocalDateTime.now()).toDays();
            fineAmount = Math.max(0, daysLate * finePerDay);
        }
        return fineAmount;
    }
    
    public void returnBook() {
        this.returnDate = LocalDateTime.now();
        this.isReturned = true;
        calculateFine(5000); // 5000 VND per day
    }
    
    public boolean isOverdue() {
        return !isReturned && LocalDateTime.now().isAfter(dueDate);
    }
    
    @Override
    public String toString() {
        String status = isReturned ? "Đã trả" : "Đang mượn";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] Thành viên: %s, Sách: %s, Trạng thái: %s, Hạn trả: %s", 
                           recordId, memberId, bookId, status, dueDate.format(formatter));
    }
}

// Class chính quản lý thư viện
class Library {
    private String libraryName;
    private Map<String, Book> books;
    private Map<String, Member> members;
    private Map<String, BorrowRecord> borrowRecords;
    private int nextRecordId;
    private final double FINE_PER_DAY = 5000.0; // VND
    
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.borrowRecords = new HashMap<>();
        this.nextRecordId = 1;
    }
    
    // Quản lý sách
    public boolean addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            System.out.println("Sách với ID " + book.getBookId() + " đã tồn tại!");
            return false;
        }
        books.put(book.getBookId(), book);
        System.out.println("Đã thêm sách: " + book);
        return true;
    }
    
    public boolean removeBook(String bookId) {
        if (!books.containsKey(bookId)) {
            System.out.println("Không tìm thấy sách với ID: " + bookId);
            return false;
        }
        
        Book book = books.get(bookId);
        if (book.getBorrowedCopies() > 0) {
            System.out.println("Không thể xóa sách " + book.getTitle() + 
                             " vì đang có " + book.getBorrowedCopies() + " bản được mượn");
            return false;
        }
        
        books.remove(bookId);
        System.out.println("Đã xóa sách: " + book.getTitle());
        return true;
    }
    
    public List<Book> searchBooks(String keyword) {
        return books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                               book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                               book.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    public List<Book> getBooksByCategory(String category) {
        return books.values().stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
    
    public List<Book> getAvailableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
    
    // Quản lý thành viên
    public boolean addMember(Member member) {
        if (members.containsKey(member.getMemberId())) {
            System.out.println("Thành viên với ID " + member.getMemberId() + " đã tồn tại!");
            return false;
        }
        members.put(member.getMemberId(), member);
        System.out.println("Đã thêm thành viên: " + member);
        return true;
    }
    
    public boolean removeMember(String memberId) {
        if (!members.containsKey(memberId)) {
            System.out.println("Không tìm thấy thành viên với ID: " + memberId);
            return false;
        }
        
        Member member = members.get(memberId);
        if (!member.getBorrowedBookIds().isEmpty()) {
            System.out.println("Không thể xóa thành viên " + member.getName() + 
                             " vì đang mượn " + member.getBorrowedBookIds().size() + " sách");
            return false;
        }
        
        members.remove(memberId);
        System.out.println("Đã xóa thành viên: " + member.getName());
        return true;
    }
    
    // Quản lý mượn/trả sách
    public boolean borrowBook(String memberId, String bookId) {
        // Kiểm tra thành viên
        if (!members.containsKey(memberId)) {
            System.out.println("Không tìm thấy thành viên với ID: " + memberId);
            return false;
        }
        
        Member member = members.get(memberId);
        if (!member.isActive()) {
            System.out.println("Thành viên " + member.getName() + " đã bị vô hiệu hóa");
            return false;
        }
        
        if (!member.canBorrowMore()) {
            System.out.println("Thành viên " + member.getName() + " đã mượn tối đa số sách cho phép");
            return false;
        }
        
        // Kiểm tra sách
        if (!books.containsKey(bookId)) {
            System.out.println("Không tìm thấy sách với ID: " + bookId);
            return false;
        }
        
        Book book = books.get(bookId);
        if (!book.isAvailable()) {
            System.out.println("Sách " + book.getTitle() + " hiện không có sẵn");
            return false;
        }
        
        // Kiểm tra thành viên đã mượn sách này chưa
        if (member.getBorrowedBookIds().contains(bookId)) {
            System.out.println("Thành viên " + member.getName() + " đã mượn sách này rồi");
            return false;
        }
        
        // Tạo bản ghi mượn sách
        String recordId = "BR" + String.format("%06d", nextRecordId++);
        BorrowRecord record = new BorrowRecord(recordId, memberId, bookId);
        
        // Cập nhật dữ liệu
        borrowRecords.put(recordId, record);
        book.borrowCopy();
        member.addBorrowedBook(bookId);
        
        System.out.println("Mượn sách thành công!");
        System.out.println("Thành viên: " + member.getName());
        System.out.println("Sách: " + book.getTitle());
        System.out.println("Hạn trả: " + record.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        
        return true;
    }
    
    public boolean returnBook(String memberId, String bookId) {
        // Tìm bản ghi mượn sách
        BorrowRecord record = findActiveBorrowRecord(memberId, bookId);
        if (record == null) {
            System.out.println("Không tìm thấy bản ghi mượn sách cho thành viên " + memberId + " và sách " + bookId);
            return false;
        }
        
        // Cập nhật bản ghi
        record.returnBook();
        
        // Cập nhật sách và thành viên
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        
        book.returnCopy();
        member.removeBorrowedBook(bookId);
        
        System.out.println("Trả sách thành công!");
        System.out.println("Thành viên: " + member.getName());
        System.out.println("Sách: " + book.getTitle());
        
        if (record.getFineAmount() > 0) {
            System.out.println("Tiền phạt trễ hạn: " + String.format("%,.0f VND", record.getFineAmount()));
        }
        
        return true;
    }
    
    private BorrowRecord findActiveBorrowRecord(String memberId, String bookId) {
        return borrowRecords.values().stream()
                .filter(record -> record.getMemberId().equals(memberId) &&
                                record.getBookId().equals(bookId) &&
                                !record.isReturned())
                .findFirst()
                .orElse(null);
    }
    
    // Báo cáo và thống kê
    public void displayLibraryStats() {
        System.out.println("\n=== THỐNG KÊ THƯ VIỆN " + libraryName.toUpperCase() + " ===");
        System.out.println("Tổng số sách: " + books.size());
        System.out.println("Tổng số thành viên: " + members.size());
        System.out.println("Tổng số bản ghi mượn: " + borrowRecords.size());
        
        int totalCopies = books.values().stream().mapToInt(Book::getTotalCopies).sum();
        int availableCopies = books.values().stream().mapToInt(Book::getAvailableCopies).sum();
        int borrowedCopies = books.values().stream().mapToInt(Book::getBorrowedCopies).sum();
        
        System.out.println("Tổng số bản sách: " + totalCopies);
        System.out.println("Có sẵn: " + availableCopies);
        System.out.println("Đang được mượn: " + borrowedCopies);
        
        long activeMembers = members.values().stream().filter(Member::isActive).count();
        System.out.println("Thành viên hoạt động: " + activeMembers);
    }
    
    public List<BorrowRecord> getOverdueRecords() {
        return borrowRecords.values().stream()
                .filter(record -> !record.isReturned() && record.isOverdue())
                .collect(Collectors.toList());
    }
    
    public void displayOverdueBooks() {
        List<BorrowRecord> overdueRecords = getOverdueRecords();
        
        if (overdueRecords.isEmpty()) {
            System.out.println("Không có sách nào quá hạn.");
            return;
        }
        
        System.out.println("\n=== DANH SÁCH SÁCH QUÁ HẠN ===");
        for (BorrowRecord record : overdueRecords) {
            Member member = members.get(record.getMemberId());
            Book book = books.get(record.getBookId());
            double fine = record.calculateFine(FINE_PER_DAY);
            
            System.out.println(String.format("Thành viên: %s (%s)", member.getName(), member.getMemberId()));
            System.out.println(String.format("Sách: %s", book.getTitle()));
            System.out.println(String.format("Hạn trả: %s", 
                             record.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            System.out.println(String.format("Tiền phạt: %,.0f VND", fine));
            System.out.println("---");
        }
    }
    
    public Map<String, Integer> getBooksByCategory() {
        return books.values().stream()
                .collect(Collectors.groupingBy(
                    Book::getCategory,
                    Collectors.summingInt(book -> 1)
                ));
    }
    
    public void displayBooksByCategory() {
        System.out.println("\n=== THỐNG KÊ SÁCH THEO THỂ LOẠI ===");
        Map<String, Integer> categoryStats = getBooksByCategory();
        
        categoryStats.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> 
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " sách"));
    }
    
    public List<Book> getMostPopularBooks(int limit) {
        Map<String, Long> borrowCount = borrowRecords.values().stream()
                .collect(Collectors.groupingBy(BorrowRecord::getBookId, Collectors.counting()));
        
        return books.values().stream()
                .sorted((b1, b2) -> {
                    long count1 = borrowCount.getOrDefault(b1.getBookId(), 0L);
                    long count2 = borrowCount.getOrDefault(b2.getBookId(), 0L);
                    return Long.compare(count2, count1);
                })
                .limit(limit)
                .collect(Collectors.toList());
    }
    
    // Utility methods
    public Book getBook(String bookId) {
        return books.get(bookId);
    }
    
    public Member getMember(String memberId) {
        return members.get(memberId);
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }
    
    public List<BorrowRecord> getAllBorrowRecords() {
        return new ArrayList<>(borrowRecords.values());
    }
}

// Class demo để test hệ thống
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Tạo thư viện
        Library library = new Library("Thư viện Trung tâm Hà Nội");
        
        // Thêm sách
        library.addBook(new Book("B001", "Lập trình Java", "Nguyễn Văn A", "978-0123456789", "Công nghệ", 2023, 5));
        library.addBook(new Book("B002", "Cấu trúc dữ liệu và giải thuật", "Trần Thị B", "978-0987654321", "Công nghệ", 2022, 3));
        library.addBook(new Book("B003", "Văn học Việt Nam", "Lê Văn C", "978-0111222333", "Văn học", 2021, 4));
        library.addBook(new Book("B004", "Lịch sử thế giới", "Phạm Thị D", "978-0444555666", "Lịch sử", 2020, 2));
        library.addBook(new Book("B005", "Toán học cao cấp", "Hoàng Văn E", "978-0777888999", "Toán học", 2023, 6));
        
        // Thêm thành viên
        library.addMember(new Member("M001", "Nguyễn Minh Tuấn", "tuan@email.com", "0912345678", "Standard"));
        library.addMember(new Member("M002", "Trần Hải Yến", "yen@email.com", "0987654321", "Premium"));
        library.addMember(new Member("M003", "Lê Thành Long", "long@email.com", "0909123456", "Standard"));
        
        System.out.println("=== KHỞI TẠO THƯ VIỆN THÀNH CÔNG ===\n");
        
        // Demo các chức năng
        System.out.println("=== DEMO CÁC CHỨC NĂNG ===");
        
        // Mượn sách
        System.out.println("\n1. MƯỢN SÁCH:");
        library.borrowBook("M001", "B001");
        library.borrowBook("M001", "B003");
        library.borrowBook("M002", "B002");
        library.borrowBook("M002", "B004");
        
        // Thống kê thư viện
        library.displayLibraryStats();
        
        // Tìm kiếm sách
        System.out.println("\n2. TÌM KIẾM SÁCH theo từ khóa 'Java':");
        List<Book> searchResults = library.searchBooks("Java");
        searchResults.forEach(System.out::println);
        
        // Hiển thị sách theo thể loại
        library.displayBooksByCategory();
        
        // Trả sách
        System.out.println("\n3. TRẢ SÁCH:");
        library.returnBook("M001", "B001");
        
        // Hiển thị sách phổ biến nhất
        System.out.println("\n4. TOP 3 SÁCH PHỔ BIẾN NHẤT:");
        List<Book> popularBooks = library.getMostPopularBooks(3);
        for (int i = 0; i < popularBooks.size(); i++) {
            System.out.println((i + 1) + ". " + popularBooks.get(i));
        }
        
        // Hiển thị sách quá hạn
        System.out.println("\n5. KIỂM TRA SÁCH QUÁ HẠN:");
        library.displayOverdueBooks();
        
        // Thống kê cuối cùng
        System.out.println("\n=== THỐNG KÊ CUỐI CÙNG ===");
        library.displayLibraryStats();
        
        // Hiển thị danh sách sách có sẵn
        System.out.println("\n6. DANH SÁCH SÁCH CÓ SẴN:");
        List<Book> availableBooks = library.getAvailableBooks();
        availableBooks.forEach(System.out::println);
    }
}