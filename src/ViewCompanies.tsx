import React, { useEffect, useState } from 'react';
import Company from './Company';
import axios from 'axios';
import {PurchaseStock} from './PurchaseStock';
import './ViewCompanies.css';

export default function ViewCompanies () { 

    var fcompany = [];

    const [query, setQuery]=useState("")
    const [companies, setCompanies]=useState<Company[]>([])
        useEffect (()=>{
        loadCompanies();
     
    }, []);

    const loadCompanies=async()=>{
        const result =await axios.get("http://localhost:8080/api/company/all")
        setCompanies(result.data);
     };

     if(query.length>0){
        fcompany=companies.filter(
          (company)=>company.ticker.toLowerCase().includes(query.toLowerCase().trim()))
      } else {
        fcompany=companies;
      }

    return (
    <React.Fragment>
      <div className='searchbar'>
        <label className='searchtext'>
          Search for a Company:
        </label>
        <input 
              type="search"
              placeholder='Company Ticker'
              onChange={(e)=>setQuery(e.target.value)} />
      </div>  
      <div className='view'>
            
        <table className = 'rtable'>
          <thead className='rhead'>
            <tr>
              <th>Company Name</th>
              <th>Ticker</th>
              <th>Market Cap</th>
              <th>Price Stock</th>
              <th>Total Number of Stocks</th>
            </tr>
          </thead>
        <tbody className='rbody'>
          {fcompany.map((c) => (
          <tr>
            <td>{c.companyname}</td>
            <td>{c.ticker}</td>
            <td>${c.mc}</td>
            <td>{c.pricestock}</td>
            <td>{c.numstock}</td>
          </tr> 
           ))
          }
        </tbody>
      </table>
    </div>
    <h2>Buy a Stock:</h2>
    <div className='purchase'>
      <PurchaseStock companies = {companies}/> 
    </div>
    </React.Fragment>
    );
}
