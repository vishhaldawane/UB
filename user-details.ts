import { Address } from "./Address";
import { Company } from "./Company";
import { GeoLocation } from "./GeoLocation";

export class UserDetails {
    id!: string;
    name!: string;
    username!: string;
    email!: string; 
        address!: Address;
    phone!: string; 
    website!: string
        company!: Company;
}

