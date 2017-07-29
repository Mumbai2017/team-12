from django.shortcuts import render
from django.http import HttpResponseRedirect,HttpResponse
from ngo.forms import *
from django.contrib.auth import login,logout
import operator
from django.core.mail import send_mail
from django.contrib.auth.decorators import login_required
import math

def home(request):


	return render(request,'home.html')

def user_login(request):
	if request.user.is_authenticated():
		return HttpResponseRedirect('/home/')
	if request.POST:
		form = LoginForm(data=request.POST)
		if form.is_valid():
			logged_in_user = form.save()
			if logged_in_user.is_active == 1:
				login(request, logged_in_user)
				return HttpResponseRedirect('/profile/')
			else:
				return HttpResponse("Not active")
	else:
		form = LoginForm()

	return render(request,'login.html',{'form':form})


def register(request):


	if request.user.is_authenticated():
		return HttpResponseRedirect('/home/')
	if request.POST:

		form = RegisterForm(data=request.POST)
		if form.is_valid():

			user = User.objects.create_user(username=form.cleaned_data['email'],email=form.cleaned_data['email'],password=form.cleaned_data['password'])


			logged_in_user = form.save(commit=False)
			logged_in_user.user = user

			logged_in_user.save()
			logged_in_user.professions = form.cleaned_data['professions']
			logged_in_user.save()
			return HttpResponseRedirect('/profile/')
		else:
			print ("nope")
	else:
		form = RegisterForm()
	return render(request,'register.html',{'form':form})



@login_required(login_url='/login/')
def profile(request):

	uu = request.user
	user = UserProfile.objects.get(user=uu)

	ulat = user.lat
	ulong = user.long
	ngosx = NGO.objects.all()
	ngos=[]

	for ngo in ngosx:

		for prof in ngo.professions.all():
			if prof == 100:
				ngos.append(ngo)
				break
			if prof in user.professions.all():
				ngos.append(ngo)
				break

	for ngo in ngos:
		ngolat = ngo.lat
		ngolong=ngo.long
		ngo.dist = ((ulat-ngolat)*(ulat-ngolat) + (ulong-ngolong)*(ulong-ngolong))
	ngos = sorted(ngos,key=operator.attrgetter('dist'))
	ngo1 = []
	ngo2 = []
	ngo3 = []
	for ngo in ngos:
		if ngo.pref1 == user.pref1:
			ngo1.append(ngo)
		if ngo.pref1 == user.pref2:
			ngo2.append(ngo)
		if ngo.pref1 == user.pref3:
			ngo3.append(ngo)

	if request.POST:

		mail = request.POST.get('mail')

		userm = UserProfile.objects.get(user=request.user)
		name = str(userm.user.username)
		phone = str(userm.phone_number)
		email = str(userm.user.email)
		send_mail("Volunteer Registration","I am "+name+"available to volunteer at your NGO my phone number is "+phone+"email is "+email,'admin@rosharo.co.in',["suhailsbarot@gmail.com"],fail_silently=False)



	return render(request,'profile.html',{'ngo1':ngo1,'ngo2':ngo2,'ngo3':ngo3,'user':user})


def aboutus(request):

	return render(request)


@login_required(login_url='/login/')
def user_logout(request):

	logout(request)
	return HttpResponseRedirect('/home/')

def faq(request):

	return render(request,'faq1.html')
