package ecommerce.application.interfaces;

import ecommerce.application.models.Password;
import ecommerce.application.models.account.Address;

public interface Builder {
    public Builder setName(String name);
    public Builder setEmail(String email);
    public Builder setPassword(Password password);
    public Builder setCNPJ(String cnpj);
    public Builder addAddress(Address address);
}
