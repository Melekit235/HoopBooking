import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgIf, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  standalone: true,
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css',
  ],
  imports: [NgIf, FormsModule]
})
export class LoginPageComponent {
  email: string = '';
  passwordHash: string = '';
  message: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  handleSubmit() {
    const payload = {
      email: this.email,
      passwordHash: this.passwordHash,
    };

    this.http.post('http://localhost:8080/login', payload).subscribe({
      next: (response: any) => {
        console.log('Успешный вход:', response);
        this.message = 'Успешный вход!';
        localStorage.setItem('userId', response);

        setTimeout(() => {
          this.router.navigate(['/courts']);
        }, 1000);
      },
      error: () => {
        this.message = 'Ошибка входа: Неверный email или пароль.';
      },
    });
  }
}
