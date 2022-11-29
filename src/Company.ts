export default class Company {
    id: number;
    companyname: string;
    ticker: string;
    mc: number;
    pricestock: number;
    numstock: number;


    constructor (id: number, companyname: string, ticker: string, mc: number, pricestock: number, numstock: number) {
        this.id = id;
        this.companyname = companyname;
        this.ticker = ticker;
        this.mc = mc;
        this.pricestock = pricestock;
        this.numstock = numstock;
    }
}