import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register-page',
  standalone: true,
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css'],
  imports: [NgIf, FormsModule]
})
export class RegisterPageComponent {
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  passwordHash: string = '';
  message: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  handleSubmit() {
    const payload = {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
      passwordHash: this.passwordHash
    };

    this.http.post('http://localhost:8080/register', payload).subscribe({
      next: (response) => {
        console.log('Регистрация успешна:', response);
        this.message = 'Регистрация успешна!';
        setTimeout(() => this.router.navigate(['/login']), 1000);
      },
      error: () => {
        this.message = 'Ошибка регистрации. Попробуйте снова.';
      }
    });
  }
}
