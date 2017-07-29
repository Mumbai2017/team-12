from django import forms
from django.contrib.auth import authenticate
from ngo.models import *
from django.contrib.auth.models import User




class LoginForm(forms.Form):
    """
    Login form for all
    """
    username = forms.EmailField(widget=forms.TextInput(attrs=dict(maxlength=75)), label=u'Username:')
    password = forms.CharField(widget=forms.PasswordInput(render_value=False), label=u'Password:')

    def clean(self):
        """
        Check if user pass combination is correct

        :return:
        """
        if 'username' in self.cleaned_data and 'password' in self.cleaned_data:
            if not authenticate(username=self.cleaned_data['username'], password=self.cleaned_data['password']):
                raise forms.ValidationError(u'The user-password combination is incorrect')
        return self.cleaned_data


    def save(self):
        return authenticate(username=self.cleaned_data['username'], password=self.cleaned_data['password'])


class RegisterForm(forms.ModelForm):

    email = forms.EmailField()
    password = forms.CharField(widget=forms.PasswordInput())
    lat = forms.DecimalField(widget=forms.HiddenInput)
    long = forms.DecimalField(widget=forms.HiddenInput)
    class Meta:
        model = UserProfile
        exclude = ('user',)
