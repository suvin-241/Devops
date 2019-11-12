import React from "react";
import { callGet } from "../service/ApiService";
import { GET_CUSTOMER } from "../common/Urlconstants";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { withStyles, makeStyles } from '@material-ui/core/styles';


const StyledTableCell = withStyles(theme => ({
    head: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
    },
    body: {
      fontSize: 14,
    },
  }))(TableCell);

  const StyledTableRow = withStyles(theme => ({
    root: {
      '&:nth-of-type(odd)': {
        backgroundColor: theme.palette.background.default,
      },
    },
  }))(TableRow);


class CustomerComponent extends React.Component{

constructor(props){
super(props);
this.state={
    customerdata:null
}
}

componentDidMount(){
    callGet(GET_CUSTOMER).then(response=>{
        this.setState({customerdata:response.data});

    })
}
    render(){
        return(
<div>
<Table className="custom-table" styles={{width:"75%"}} aria-label="customized table">
        <TableHead>
          <TableRow>
          <StyledTableCell>Customer ID</StyledTableCell>
            <StyledTableCell align="right">Title</StyledTableCell>
            <StyledTableCell align="right">First Name</StyledTableCell>
            <StyledTableCell align="right">Last Name</StyledTableCell>
            <StyledTableCell align="right">Email</StyledTableCell>
            <StyledTableCell align="right">Mobile Number</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {this.state.customerdata && this.state.customerdata.map(row => (
            <StyledTableRow key={row.customerid}>
              <StyledTableCell component="th" scope="row">
                  {row.customerid}
              </StyledTableCell>
              <StyledTableCell align="right">{row.title}</StyledTableCell>
              <StyledTableCell align="right">{row.firstname}</StyledTableCell>
              <StyledTableCell align="right">{row.lastname}</StyledTableCell>
              <StyledTableCell align="right">{row.email}</StyledTableCell>
              <StyledTableCell align="right">{row.mobileno}</StyledTableCell>

            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    
    
</div>

        );
    }
}

export default CustomerComponent;