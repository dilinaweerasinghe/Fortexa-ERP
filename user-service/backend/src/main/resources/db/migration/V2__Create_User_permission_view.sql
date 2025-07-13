CREATE VIEW user_permissions AS
SELECT rp.permission_id, p.permission,u.username
FROM RolePermission rp
JOIN Role r ON rp.role_id = r.role_id
JOIN UserRole ur ON ur.role_id = r.role_id
JOIN User u ON u.user_id = ur.user_id
JOIN Permission p ON rp.permission_id = p.permission_id;