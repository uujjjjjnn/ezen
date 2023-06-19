import React from 'react';
import { useParams } from 'react-router-dom';

const data = {
  sonny: {
    name: '손흥민',
    description: 'EPL 토트넘 선수'
  },
  kangin: {
    name: '이강인',
    description: '스페인 마요르카 선수'
  }
}
const Profile = () => {

  const params = useParams();
  const profile = data[params.username]
  return (
    <div>
      <h1>축구선수 프로필</h1>
      {profile ? (
        <div>
          <h2>{profile.name}</h2>
          <p>{profile.description}</p>
        </div>
      ) : (
        <p>존재하지 않는 프로필입니다</p>
      )}
    </div>
  );
};

export default Profile;