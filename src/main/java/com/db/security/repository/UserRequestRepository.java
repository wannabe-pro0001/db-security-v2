package com.db.security.repository;


import com.db.security.model.UserRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRequestRepository extends JpaRepository<UserRequestEntity, Long> {
    UserRequestEntity findByPassportId(String passportId);

    // chỗ này phải viết v á =)) nếu ko th jpa nó update hết các field
    @Modifying
    @Query(value = "update passport.user_request u set u.is_authenticated = 1 where u.id = ?", nativeQuery=true) 
    void AuthenticateUserRequest(Long id);

    @Modifying
    @Query("update UserRequestEntity u set u.isApprove = 1 where u.id = ?1")
    void ApproveUserRequest(Long id);

    @Modifying
    @Query("update UserRequestEntity u set u.isRejected = 1 where u.id = ?1")
    void RejectUserRequest(Long id);
}
