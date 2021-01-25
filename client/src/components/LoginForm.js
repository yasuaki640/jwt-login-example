import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-bootstrap/Form'
import 'react-bootstrap/Button';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useState} from "react";

export const LoginForm = () => {
    const [loginId, setLoginId] = useState('');
    const handleLoginIdChange = e => setLoginId(e.target.value);

    const [password, setPassword] = useState('');
    const handlePasswordChange = e => setPassword(e.target.value);

    const handleSubmit = async e => {
        e.preventDefault();
        alert('loginId : ' + loginId);
        alert('password : ' + password);
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="formLoginId">
                <Form.Label>Login ID </Form.Label>
                <Form.Control type="text"
                              placeholder="Enter loginId"
                              value={loginId}
                              onChange={handleLoginIdChange}/>
                <Form.Text className="text-muted">
                    We'll never share your loginId with anyone else.<br/>
                </Form.Text>
            </Form.Group>

            <Form.Group controlId="formPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password"
                              placeholder="Password"
                              value={password}
                              onChange={handlePasswordChange}
                />
            </Form.Group>
            <Form.Group controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Check me out"/>
            </Form.Group>
            <Button variant="primary" type="submit">
                Submit
            </Button>
        </Form>
    );
}
