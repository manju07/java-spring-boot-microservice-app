-- Password=Test@123
INSERT IGNORE INTO oauth_client_details
(client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, authorized_grant_types, additional_information) 
VALUES ('R2dpxQ3vPrtfgF72', '$2a$12$XiqT0bmmBJx5Sl/dGOtSl.FrSqFzjyZuZPJVwa3In0wxKtGYeej2u', 'http://localhost:8765/login', 'READ,WRITE', '3600', '10000', 'authorization_code,password,refresh_token,implicit', '{}');