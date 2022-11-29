import React, { useState } from "react";
import axios from 'axios'
import Company from './Company';
import './PurchaseStock.css';

interface Companies{
    companies:Array<Company>,
}

export const PurchaseStock = (props: Companies) => {

    const [amount,setAmount]=useState('');
    const [numpurchase,setNumpurchase]=useState('');
    const [ticker,setTicker]=useState('');
    const [warning,setWarning]=useState(false);

    let bodyFormData = new FormData();

    const onSubmit=async(e:any)=>{ 
        let sel =props.companies.filter(
            (company)=>company.ticker.includes(ticker))
        if(+numpurchase < sel[0].numstock){
            bodyFormData.append('ticker', ticker);
            bodyFormData.append('amount', amount);
            bodyFormData.append('num', numpurchase);
            console.log(amount + " "+ numpurchase+ " " + ticker);
            await axios({
                method:'put',
                url: 'http://localhost:8080/api/company/buy',
                data: bodyFormData,
                headers: { "Content-Type": "multipart/form-data" },
            })
        }else {
            e.preventDefault();
            setWarning(true);
            console.log(warning);
        }
    };

    return(
        <React.Fragment>
            <div>
           <form onSubmit={(e)=>onSubmit(e)}>
                    <div className='mb-3'>
                        <label className='form-label'>
                            Ticker:
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder='Enter Ticker'
                            name="Ticker"
                            onChange={e => setTicker(e.target.value)}
                 
                        />
                    </div>
                    <div className='mb-3'>
                        <label className='form-label'>
                            Number of Stocks to Buy:
                        </label>
                        <input
                            type={"number"}
                            className="form-control"
                            placeholder='Number'
                            name="Number"
                            onChange={e => setNumpurchase(e.target.value)}
                 
                        />
                        
                    </div>
                    <div className='mb-3'>
                        <label className='form-label'>
                            Stock Purchase Price:
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder='Price'
                            name="Price"
                            onChange={e => setAmount(e.target.value)}
                 
                        />
                       
                    </div>

                <button type='submit' className='btn btn-outline-primary mx-2'>Submit</button>

                  </form>
                  </div>
                <div>
                    {warning && 
                    <b>You're trying to buy too many stocks.</b>
                }
                    </div>  
                
        </React.Fragment>
    );


}